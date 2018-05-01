package com.twixttechnologies.sofo.view.profile;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivity;

/**
 * @author Sony Raj on 18/12/17.
 */

public class ProfileActivity extends BaseActivity implements ConnectProfileFragment.OnConnectListener {

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_frame_layout_with_custom_toolbar);
        addFragment(new ConnectProfileFragment());
    }

    @Override
    public void onConnect() {
        addFragment(new ProfileFragment());
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
    }
}
