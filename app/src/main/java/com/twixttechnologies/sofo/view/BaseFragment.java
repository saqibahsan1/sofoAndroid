package com.twixttechnologies.sofo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @author Sony Raj on 1/12/17.
 */

public abstract class BaseFragment extends Fragment {

    protected abstract void onBaseCreate(Bundle savedInstanceState);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        onBaseCreate(savedInstanceState);
    }
}
