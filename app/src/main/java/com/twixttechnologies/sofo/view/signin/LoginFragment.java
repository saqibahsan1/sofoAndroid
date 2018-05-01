package com.twixttechnologies.sofo.view.signin;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.google.firebase.auth.FirebaseUser;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.utils.M;
import com.twixttechnologies.sofo.view.BaseFragment;
import com.twixttechnologies.sofo.view.dashboard.DashboardActivity;
import com.twixttechnologies.sofo.view.location.LocationActivity;
import com.twixttechnologies.sofo.view.settings.auth.ForgotPasswordActivity;
import com.twixttechnologies.sofo.view.signup.SignUpActivity;
import com.twixttechnologies.sofo.viewmodel.LoginViewModel;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 8/12/17.
 */

public class LoginFragment extends BaseFragment {

    public static final String TAG = "loginFragment";

    //region Butterknife injections

    @BindView(R.id.txtUserName)
    AppCompatEditText mTxtUserName;
    @BindView(R.id.txtPassword)
    AppCompatEditText mTxtPassword;
    Unbinder unbinder;

    //endregion

    private LoginViewModel mViewModel;

    private Observer<FirebaseUser> mUserObserver;

    private boolean onActivtyResultCalledOnce = false;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this,
                new LoginViewModel.LoginViewModelFactory(getActivity().getApplication()))
                .get(LoginViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUserObserver();
        mViewModel.getUserData().observe(this, mUserObserver);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (onActivtyResultCalledOnce) {
            onActivtyResultCalledOnce = false;
            return;
        }
        if (mViewModel.getSelectedLoginType() == LoginViewModel.TWITTER) {
            if (mViewModel.getTwitterAuthClient() != null) {
                mViewModel.getTwitterAuthClient().onActivityResult(requestCode, resultCode, data);
            }
        } else if (mViewModel.getSelectedLoginType() == LoginViewModel.FACEBOOK) {
            final CallbackManager callbackManager = mViewModel.getCallbackManager();
            if (callbackManager == null) return;
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        onActivtyResultCalledOnce = true;
    }


    //region private functions

    private void initUserObserver() {
        if (mUserObserver != null) return;
        mUserObserver = new Observer<FirebaseUser>() {
            @Override
            public void onChanged(@Nullable FirebaseUser firebaseUser) {
                if (firebaseUser == null) return;
                M.showToast(getActivity(), "Welcome " + firebaseUser.getDisplayName(), true);
                startActivity(new Intent(getActivity(), LocationActivity.class));
            }
        };
    }

    //endregion

    //region click handlers

    @OnClick(R.id.btnForgotPassword)
    public void onMBtnForgotPasswordClicked() {
        startActivity(new Intent(getActivity(), ForgotPasswordActivity.class));
        getActivity().overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
    }

    @OnClick(R.id.btnFacebook)
    public void onMBtnFacebookClicked() {
        mViewModel.doFaceBookLogin(this);
    }

    @OnClick(R.id.btnGooglePlus)
    public void onMBtnGooglePlusClicked() {
    }

    @OnClick(R.id.btnTwitter)
    public void onMBtnTwitterClicked() {
        mViewModel.doTwitterLogin(new WeakReference<Activity>(getActivity()));
    }

    @OnClick(R.id.btnLogin)
    public void onMBtnLoginClicked() {
        Intent intent = new Intent(getActivity(), DashboardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.right_in,R.anim.left_out);
        getActivity().finish();
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick(R.id.btnRegister)
    public void onMBtnRegisterClicked() {
        Intent intent = new Intent(getActivity(), SignUpActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.left_out,R.anim.right_in);
        getActivity().finish();
    }

    //endregion


}
