package com.twixttechnologies.sofo.view.location;

import android.os.Bundle;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

import butterknife.ButterKnife;

/**
 * @author Sony Raj on 8/12/17.
 */

public class LocationActivity extends BaseActivityWithToolbar {


    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        ButterKnife.bind(this);
        addFragment(new LocationFragment(), LocationFragment.class.getName(), false);
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            setTitle("Near By");
        } catch (Exception e) {
            //ignore
        }

        /*if (findViewById(R.id.btnSearch) != null)
            findViewById(R.id.btnSearch).setVisibility(View.VISIBLE);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.top_out, R.anim.bottom_in);
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.top_out, R.anim.bottom_in);
    }
}
