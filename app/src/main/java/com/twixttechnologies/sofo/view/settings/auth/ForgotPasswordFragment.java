package com.twixttechnologies.sofo.view.settings.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 8/12/17.
 */

public class ForgotPasswordFragment extends BaseFragment {

    @BindView(R.id.txtUserName)
    AppCompatEditText mTxtUserName;
    Unbinder unbinder;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password_step_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(),ForgotPasswordActivityStepTwo.class));
        getActivity().overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
}
