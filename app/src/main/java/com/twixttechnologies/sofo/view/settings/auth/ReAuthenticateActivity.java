package com.twixttechnologies.sofo.view.settings.auth;

import android.os.Bundle;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 8/12/17.
 */

public class ReAuthenticateActivity extends BaseActivityWithToolbar {
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout_two);
        addFragment(new ReAuthenticateFragment());
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception e){
            //ignore
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.left_in, R.anim.right_out);
            return true;
        }
        return false;
    }

}
