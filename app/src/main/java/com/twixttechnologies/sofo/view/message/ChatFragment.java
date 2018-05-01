package com.twixttechnologies.sofo.view.message;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.adapter.list.ChatAdapter;
import com.twixttechnologies.sofo.view.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 14/12/17.
 */

public class ChatFragment extends BaseFragment {


    @BindView(R.id.lstMessages)
    RecyclerView mLstMessages;
    Unbinder unbinder;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLstMessages.setAdapter(new ChatAdapter(null, getActivity()));
        mLstMessages.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnLocation)
    public void onViewClicked() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Location sharing")
                .setMessage("Select what you want")
                .setPositiveButton("Share", null)
                .setNegativeButton("Request", null)
                .setNeutralButton("Cancel", null)
                .setCancelable(true)
                .show();

    }
}
