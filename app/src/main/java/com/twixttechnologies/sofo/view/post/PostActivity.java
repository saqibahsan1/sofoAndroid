package com.twixttechnologies.sofo.view.post;

import android.os.Bundle;
import android.view.Menu;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;

/**
 * @author Sony Raj on 14/12/17.
 */

public class PostActivity extends BaseActivityWithToolbar {
    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_toolbar_layout);
        addFragment(new PostFragment());
        setTitle("Post");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
