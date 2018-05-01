package com.twixttechnologies.sofo.view.settings;

import android.os.Bundle;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 14/12/17.
 */

public class BecomePremiumActivity extends BaseActivityWithToolbar {

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        addFragment(new BecomePremiumFragment());
    }
}
