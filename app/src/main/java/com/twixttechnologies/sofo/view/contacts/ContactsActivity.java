package com.twixttechnologies.sofo.view.contacts;

import android.os.Bundle;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

import butterknife.ButterKnife;

/**
 * @author Sony Raj on 14/12/17.
 */

public class ContactsActivity extends BaseActivityWithToolbar {

    private int mIsfromBottom = 0;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        ButterKnife.bind(this);
        addFragment(new ContactsFragment());
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            setTitle("Contact List");
        } catch (Exception e) {
            //ignore
        }

        mIsfromBottom = getIntent().getIntExtra("bottom", 0);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
            return true;
        }
        return false;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mIsfromBottom == 1) {
            overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
        } else {
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }

}
