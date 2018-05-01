package com.twixttechnologies.sofo.view.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.BaseFragment;
import com.twixttechnologies.sofo.view.post.PostActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 8/1/18.
 */

public class ConnectProfileFragment extends BaseFragment {

    Unbinder unbinder;
    private OnConnectListener mOnConnectListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mOnConnectListener = (OnConnectListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_connect, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnConnectListener = null;
    }

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnConnect)
    public void onViewClicked() {
        if (mOnConnectListener != null)
            mOnConnectListener.onConnect();
    }

    @OnClick(R.id.btnPost)
    public void onpostClicked() {
        startActivity(new Intent(getActivity(), PostActivity.class));
    }

    interface OnConnectListener {
        void onConnect();
    }

}
