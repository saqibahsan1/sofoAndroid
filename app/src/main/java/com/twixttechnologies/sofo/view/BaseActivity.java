package com.twixttechnologies.sofo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.twixttechnologies.sofo.R;

/**
 * @author Sony Raj on 1/12/17.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected abstract void onBaseCreate(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //perform any app specific checking or initialization here

        onBaseCreate(savedInstanceState);
    }

    @SuppressWarnings("unused")
    @Nullable
    protected Fragment getFragmentIfPresent(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    protected void addFragment(int containerId, BaseFragment fragment, String tag,
                               boolean addToBAckStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment, tag);
        if (addToBAckStack)
            transaction.addToBackStack(tag);
        transaction.commit();
    }

    protected void addFragment(BaseFragment fragment, String tag,
                               @SuppressWarnings("SameParameterValue") boolean addToBackStack) {
        addFragment(R.id.mainContainer, fragment, tag, addToBackStack);
    }

    protected void addFragment(BaseFragment fragment, String tag) {
        addFragment(fragment, tag, false);
    }

    @SuppressWarnings("unused")
    protected void addFragment(BaseFragment fragment) {
        addFragment(fragment, fragment.getClass().getName());
    }

}
