package com.twixttechnologies.sofo.view.signup;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivity;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 8/12/17.
 */

public class SignUpActivity extends BaseActivity {
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_frame_layout);
        addFragment(new SignUpFragment());
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception e){
            //ignore
        }
    }
}
