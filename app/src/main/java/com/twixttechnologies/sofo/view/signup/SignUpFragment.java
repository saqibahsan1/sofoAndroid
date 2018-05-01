package com.twixttechnologies.sofo.view.signup;

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
import com.twixttechnologies.sofo.view.dashboard.DashboardActivity;
import com.twixttechnologies.sofo.view.signin.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 8/12/17.
 */

public class SignUpFragment extends BaseFragment {

    @BindView(R.id.txtName)
    AppCompatEditText mTxtName;
    @BindView(R.id.txtEmail)
    AppCompatEditText mTxtEmail;
    @BindView(R.id.txtUserName)
    AppCompatEditText mTxtUserName;
    @BindView(R.id.txtAddress)
    AppCompatEditText mTxtAddress;
    Unbinder unbinder;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @SuppressWarnings("ConstantConditions")
    @OnClick({R.id.btnRegister, R.id.btnLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnRegister: {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.right_in,R.anim.left_out);
                getActivity().finish();
                break;
            }
            case R.id.btnLogin: {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.left_in, R.anim.right_out);
                getActivity().finish();
                break;
            }
        }
    }
}
