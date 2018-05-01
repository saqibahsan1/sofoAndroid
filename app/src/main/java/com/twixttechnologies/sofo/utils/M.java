package com.twixttechnologies.sofo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * @author Sony Raj on 8/12/17.
 */

public abstract class M {

    public static void log(String tag, String message) {
        Log.e(tag, message);
    }

    public static void log(String message) {
        log("sofo", message);
    }

    public static void showToast(Context context, String message, boolean longToast) {
        Toast.makeText(context, message, longToast ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT)
                .show();
    }

    public static void showSnackBar(View view, String message,
                                    @BaseTransientBottomBar.Duration int duration) {
        Snackbar.make(view, message, duration);
    }

    @SuppressLint("Range")
    public static void showSnackBar(View view, String message) {
        showSnackBar(view, message, Snackbar.LENGTH_SHORT);
    }

}
