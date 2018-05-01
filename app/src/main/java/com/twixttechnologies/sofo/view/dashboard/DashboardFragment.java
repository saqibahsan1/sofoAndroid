package com.twixttechnologies.sofo.view.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.adapter.list.DashboardLocationAdapter;
import com.twixttechnologies.sofo.adapter.list.FeaturedAroundAdapter;
import com.twixttechnologies.sofo.view.BaseFragment;
import com.twixttechnologies.sofo.view.contacts.ContactsActivity;
import com.twixttechnologies.sofo.view.settings.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 14/12/17.
 */

public class DashboardFragment extends BaseFragment {
    @BindView(R.id.lstDashboardFeatured)
    RecyclerView mLstDashboardFeatured;
    @BindView(R.id.lstDashboardLocations)
    RecyclerView mLstDashboardLocations;
    Unbinder unbinder;
    @BindView(R.id.chkAroundMe)
    AppCompatCheckBox mChkAroundMe;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FeaturedAroundAdapter adapter = new FeaturedAroundAdapter(null, getActivity());
        mLstDashboardFeatured.setAdapter(adapter);
        mLstDashboardFeatured.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mLstDashboardLocations.setAdapter(new DashboardLocationAdapter(null, getActivity()));
        mLstDashboardLocations.setLayoutManager(new LinearLayoutManager(getActivity()));

        mChkAroundMe.setChecked(true);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnSettings, R.id.btnChat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSettings:
                Intent intent =new Intent(getActivity(), SettingsActivity.class);
                intent.putExtra("bottom",1);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
                break;
            case R.id.btnChat:
                Intent i = new Intent(getActivity(), ContactsActivity.class);
                i.putExtra("bottom", 1);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
                break;
        }
    }
}
