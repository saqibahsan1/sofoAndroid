package com.twixttechnologies.sofo.view.location;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.adapter.list.ContactsAdapter;
import com.twixttechnologies.sofo.adapter.list.OtherContactsAdapter;
import com.twixttechnologies.sofo.view.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Sony Raj on 13/12/17.
 */

public class LocationDetailFragment extends BaseFragment {

    @BindView(R.id.imgMapImage)
    AppCompatImageView mImgMapImage;
    @BindView(R.id.imgLocationImage)
    CircleImageView mImgLocationImage;
    @BindView(R.id.rtRating)
    AppCompatRatingBar mRtRating;
    @BindView(R.id.lstMyContacts)
    RecyclerView mLstMyContacts;
    @BindView(R.id.lstOtherContacts)
    RecyclerView mLstOtherContacts;
    Unbinder unbinder;
    private double lat, lng;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        Bundle args = getArguments();
        lat = args.getDouble("lat");
        lng = args.getDouble("lng");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String url = "https://maps.googleapis.com/maps/api/staticmap?center=" + lat + ","
                + lng + "&zoom=14&size=600x200&markers=color:red%7Clabel:.%7C" + lat + ","
                + lng + "&zoom=12&size=600x400";

        Glide.with(this)
                .load(url)
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        mImgMapImage.setImageDrawable(resource);
                    }
                });

        mLstMyContacts.setAdapter(new ContactsAdapter(null, getActivity()));
        mLstMyContacts.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mLstOtherContacts.setAdapter(new OtherContactsAdapter(null, getActivity()));
        mLstOtherContacts.setLayoutManager(new GridLayoutManager(getActivity(), 4,GridLayoutManager.VERTICAL,false));

    }

    public static LocationDetailFragment newInstance(double lat, double lng) {
        Bundle args = new Bundle();
        args.putDouble("lat", lat);
        args.putDouble("lng", lng);
        LocationDetailFragment fragment = new LocationDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
