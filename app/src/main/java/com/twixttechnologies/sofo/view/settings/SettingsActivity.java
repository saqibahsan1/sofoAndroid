package com.twixttechnologies.sofo.view.settings;

import android.os.Bundle;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 8/12/17.
 */

public class SettingsActivity extends BaseActivityWithToolbar {

    private int mIsFromBottom = 0;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.settings);
        addFragment(new SettingsFragment());
        setTitle("Settings");
        mIsFromBottom = getIntent().getIntExtra("bottom", 0);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            if (mIsFromBottom == 1) {
                overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
            } else {
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mIsFromBottom == 1) {
            overridePendingTransition(R.anim.top_in, R.anim.bottom_out);
        } else {
            overridePendingTransition(R.anim.right_in, R.anim.left_out);
        }
    }
}
