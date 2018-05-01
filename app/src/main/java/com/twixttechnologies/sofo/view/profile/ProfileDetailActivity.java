package com.twixttechnologies.sofo.view.profile;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivity;

/**
 * @author Sony Raj on 15/1/18.
 */

public class ProfileDetailActivity extends BaseActivity {

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_frame_layout_with_custom_toolbar);
        addFragment(new ProfileFragment());
    }

}
