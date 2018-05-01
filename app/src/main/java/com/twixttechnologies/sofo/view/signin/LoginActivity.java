package com.twixttechnologies.sofo.view.signin;

import android.content.Intent;
import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivity;

/**
 * @author Sony Raj on 8/12/17.
 */

public class LoginActivity extends BaseActivity {

    private LoginFragment mLoginFragment;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_frame_layout);
        mLoginFragment = (LoginFragment) getFragmentIfPresent(LoginFragment.TAG);
        if (mLoginFragment == null)
            mLoginFragment = new LoginFragment();
        addFragment(mLoginFragment, LoginFragment.TAG, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mLoginFragment.onActivityResult(requestCode, resultCode, data);
    }
}
