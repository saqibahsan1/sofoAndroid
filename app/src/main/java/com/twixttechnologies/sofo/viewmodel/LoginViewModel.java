package com.twixttechnologies.sofo.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TwitterAuthProvider;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.utils.M;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sony Raj on 8/12/17.
 */
public class LoginViewModel extends ViewModelBase {


    private LoginViewModel(Application application) {
        super(application);
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    //region selected login type

    private int mSelectedLoginType = -1;
    public static final int GOOGLE = 237;
    public static final int TWITTER = 606;
    public static final int FACEBOOK = 830;

    public int getSelectedLoginType() {
        return mSelectedLoginType;
    }

    //endregion


    //region twitter

    private TwitterConfig mTwitterConfig;
    private TwitterAuthConfig mTwitterAuthConfig;
    private TwitterAuthClient mTwitterAuthClient;

    public TwitterAuthClient getTwitterAuthClient() {
        return mTwitterAuthClient;
    }

    private void initTwitter() {
        if (mTwitterAuthConfig == null) {
            //Todo fetch twitter from web api and store it in memory
            //don't store secret key else-where
            mTwitterAuthConfig = new TwitterAuthConfig(
                    getApplication().getString(R.string.twitter_key),
                    getApplication().getString(R.string.twitter_secret));
        }

        if (mTwitterConfig == null) {
            //todo change debug to false when release
            mTwitterConfig = new TwitterConfig.Builder(this.getApplication())
                    .twitterAuthConfig(mTwitterAuthConfig)
                    .debug(true)
                    .build();
        }

        Twitter.initialize(mTwitterConfig);

        if (mTwitterAuthClient == null) {
            mTwitterAuthClient = new TwitterAuthClient();
        }
    }

    public void doTwitterLogin(WeakReference<Activity> activity) {
        initTwitter();
        mSelectedLoginType = TWITTER;
        mTwitterAuthClient.authorize(activity.get(), new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                handleTwitterSession(result.data);
            }

            @Override
            public void failure(TwitterException exception) {
                mErrorData.setValue(exception.getMessage());
            }
        });
    }

    private void handleTwitterSession(TwitterSession session) {
        AuthCredential authCredential = TwitterAuthProvider.getCredential(
                session.getAuthToken().token,
                session.getAuthToken().secret
        );
        authenticateWithFirebase(authCredential, "Login failed, Please try again later");
    }

    //endregion

    //region facebook

    private CallbackManager mCallbackManager;

    public CallbackManager getCallbackManager() {
        return mCallbackManager;
    }

    private void initFacebook(Fragment fragment) {
        if (mCallbackManager == null)
            mCallbackManager = CallbackManager.Factory.create();

        final String messageIfFailed = "An Error occurred when login in with facebook";

        LoginManager loginManager = LoginManager.getInstance();
        loginManager.registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookLogin(loginResult, messageIfFailed);
                    }

                    @Override
                    public void onCancel() {
                        M.log("facebook login cancelled");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        mErrorData.setValue(messageIfFailed);
                    }
                });
        List<String> permissions = new ArrayList<>(1);
        permissions.add("public_profile");
        loginManager.logInWithReadPermissions(fragment, permissions);

    }

    private void handleFacebookLogin(LoginResult loginResult, String messageIfFailed) {
        AuthCredential authCredential = FacebookAuthProvider
                .getCredential(loginResult.getAccessToken().getToken());
        authenticateWithFirebase(authCredential, messageIfFailed);
    }

    public void doFaceBookLogin(Fragment fragment) {
        mSelectedLoginType = FACEBOOK;
        initFacebook(fragment);
    }

    //endregion

    //region firebase

    private final FirebaseAuth mFirebaseAuth;

    private MutableLiveData<FirebaseUser> mUserData = new MutableLiveData<>();

    public MutableLiveData<FirebaseUser> getUserData() {
        return mUserData;
    }

    //firebase auth handler
    @SuppressWarnings("SameParameterValue")
    private void authenticateWithFirebase(AuthCredential authCredential,
                                          final String messageIfFailed) {
        mFirebaseAuth.signInWithCredential(authCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            mErrorData.setValue(messageIfFailed);
                        } else {
                            mUserData.setValue(task.getResult().getUser());
                        }
                    }
                });
    }

    //endregion


    @SuppressWarnings("unchecked")
    public static class LoginViewModelFactory implements ViewModelProvider.Factory {

        private final Application mApplication;

        public LoginViewModelFactory(Application application) {
            mApplication = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new LoginViewModel(mApplication);
        }
    }


}