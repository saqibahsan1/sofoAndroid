package com.twixttechnologies.sofo.view.location;

import android.content.Intent;
import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 13/12/17.
 */

public class LocationDetailActivity extends BaseActivityWithToolbar {

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);

        Intent callingIntent = getIntent();
        double lat = callingIntent.getDoubleExtra("lat", 0);
        double lng = callingIntent.getDoubleExtra("lng", 0);
        addFragment(LocationDetailFragment.newInstance(lat, lng));

        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            setTitle("Location Detail");
        } catch (Exception e) {
            //ignore
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
    }
}
