package com.twixttechnologies.sofo.view.settings.auth;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;

/**
 * @author Sony Raj on 8/12/17.
 */

public class ForgotPasswordActivity extends ForgotPasswordActivityBase {

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addFragment(new ForgotPasswordFragment());
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception e){
            //ignore
        }
    }
}
