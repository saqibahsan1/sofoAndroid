package com.twixttechnologies.sofo.view.dashboard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.utils.M;
import com.twixttechnologies.sofo.view.BaseActivity;
import com.twixttechnologies.sofo.view.contacts.ContactsActivity;
import com.twixttechnologies.sofo.view.location.LocationActivity;
import com.twixttechnologies.sofo.view.message.ChatActivity;
import com.twixttechnologies.sofo.view.profile.ProfileActivity;
import com.twixttechnologies.sofo.view.settings.BecomePremiumActivity;
import com.twixttechnologies.sofo.view.settings.SettingsActivity;
import com.twixttechnologies.sofo.view.signin.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Sony Raj on 14/12/17.
 */

public class DashboardActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.mainContainer)
    LinearLayout mMainContainer;
    @BindView(R.id.imgDp)
    CircleImageView mImgDp;
    @BindView(R.id.lblUserName)
    AppCompatTextView mLblUserName;
    @BindView(R.id.lblFollowers)
    AppCompatTextView mLblFollowers;
    @BindView(R.id.lblMessage)
    AppCompatTextView mLblMessage;
    @BindView(R.id.lblMessageCount)
    AppCompatTextView mLblMessageCount;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.lblTitle)
    AppCompatTextView mLblTitle;
    @BindView(R.id.btnProfile)
    View mBtnProfile;
    @BindView(R.id.btnMessages)
    View mBtnMessages;
    @BindView(R.id.btnContacts)
    View mBtnContacts;
    @BindView(R.id.btnBecomePremium)
    View mBtnBecomePremium;
    @BindView(R.id.btnSettings)
    View mBtnSettings;
    @BindView(R.id.btnLogout)
    View mBtnLogout;
    @BindView(R.id.btnClose)
    AppCompatImageButton mBtnClose;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_drawer_layout);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (Build.VERSION.SDK_INT>=21){
                    try {
                        getWindow().setStatusBarColor(
                                ContextCompat.getColor(DashboardActivity.this,
                                        android.R.color.transparent));
                    } catch (Exception e){
                        M.log(e.getMessage());
                    }
                }
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                super.onDrawerOpened(drawerView);
                if (Build.VERSION.SDK_INT>=21){
                    try {
                        getWindow().setStatusBarColor(
                                ContextCompat.getColor(DashboardActivity.this,
                                        android.R.color.white));
                    } catch (Exception e){
                        M.log(e.getMessage());
                    }
                }
            }
        };
        actionBarDrawerToggle.syncState();
        addFragment(new DashboardFragment());
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_24_black);
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mLblTitle.setText("sofo");
            mLblTitle.setTextColor(getResources().getColor(android.R.color.black));
            mLblTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        } catch (Exception e) {
            //ignore
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        getMenuInflater().inflate(R.menu.location_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuLocation) {
            startActivity(new Intent(this, LocationActivity.class));
            overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btnMessages, R.id.btnContacts, R.id.btnSettings, R.id.btnLogout,
            R.id.btnClose, R.id.btnBecomePremium, R.id.btnProfile, R.id.imgDp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
            case R.id.btnMessages:
                startActivity(new Intent(this, ContactsActivity.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
                break;
            case R.id.btnContacts:
                startActivity(new Intent(this, ContactsActivity.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
                break;
            case R.id.btnSettings:
                startActivity(new Intent(this, SettingsActivity.class));
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
                break;
            case R.id.btnLogout:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(R.anim.left_in,R.anim.right_out);
                finishAffinity();
                break;
            case R.id.btnClose:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.btnBecomePremium:
                startActivity(new Intent(this, BecomePremiumActivity.class));
                break;
            case R.id.btnProfile:
                startActivity(new Intent(this, ProfileActivity.class));
                overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
