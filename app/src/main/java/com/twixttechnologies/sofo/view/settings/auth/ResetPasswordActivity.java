package com.twixttechnologies.sofo.view.settings.auth;

import android.os.Bundle;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;

/**
 * @author Sony Raj on 8/12/17.
 */

public class ResetPasswordActivity extends ForgotPasswordActivityBase {


    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addFragment(new ResetPasswordFragment());
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
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
