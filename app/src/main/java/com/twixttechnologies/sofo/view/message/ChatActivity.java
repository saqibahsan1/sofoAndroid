package com.twixttechnologies.sofo.view.message;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 14/12/17.
 */

public class ChatActivity extends BaseActivityWithToolbar {
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        if (findViewById(R.id.lblTitle) != null)
            findViewById(R.id.lblTitle).setVisibility(View.GONE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        addFragment(new ChatFragment());
        Glide.with(this)
                .load(R.drawable.sachin2)
                .apply(new RequestOptions().override(100, 100).transform(new CircleCrop()))
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        try {
                            getSupportActionBar().setIcon(resource);
                            getSupportActionBar().setDisplayShowTitleEnabled(true);
                            getSupportActionBar().setTitle("Sachin");
                        } catch (Exception e) {
                            //ignore
                        }
                    }
                });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
