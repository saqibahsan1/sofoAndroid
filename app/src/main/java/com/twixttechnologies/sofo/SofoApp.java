package com.twixttechnologies.sofo;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * @author Sony Raj on 8/12/17.
 */

public class SofoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
