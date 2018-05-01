package com.twixttechnologies.sofo.view;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.twixttechnologies.sofo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sony Raj on 1/12/17.
 */

public abstract class BaseActivityWithToolbar extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Nullable
    @BindView(R.id.lblTitle)
    AppCompatTextView mTitle;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null)
            throw new NullPointerException("Activities extending \"BaseActivityWithToolbar\" should" +
                    " contain a toolbar with id, \"toolbar\"");
    }

    protected void setTitle(String title){
        mTitle.setText(title);
    }

    @SuppressWarnings("unused")
    protected Toolbar getToolbar() {
        return mToolbar;
    }
}
