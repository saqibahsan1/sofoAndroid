package com.twixttechnologies.sofo.view.splash;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_frame_layout);
        addFragment(new SplashFragment());
    }

}
