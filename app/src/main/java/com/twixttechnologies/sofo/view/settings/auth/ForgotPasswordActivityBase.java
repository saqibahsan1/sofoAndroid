package com.twixttechnologies.sofo.view.settings.auth;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseActivityWithToolbar;
import com.twixttechnologies.sofo.view.signin.LoginActivity;

/**
 * @author Sony Raj on 12/12/17.
 */

abstract class ForgotPasswordActivityBase extends BaseActivityWithToolbar {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.close_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuClose) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
