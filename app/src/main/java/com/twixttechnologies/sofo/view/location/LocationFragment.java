package com.twixttechnologies.sofo.view.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.adapter.list.SwipeAdapter;
import com.twixttechnologies.sofo.utils.M;
import com.twixttechnologies.sofo.utils.contracts.ClusterItemBase;
import com.twixttechnologies.sofo.utils.extensions.BitmapToPinExtension;
import com.twixttechnologies.sofo.view.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 8/12/17.
 */

public class LocationFragment extends BaseFragment implements OnMapReadyCallback {

    Unbinder unbinder;
    @BindView(R.id.chkAroundMe)
    AppCompatCheckBox mChkAroundMe;
    @BindView(R.id.swipeView)
    RecyclerView mSwipeView;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.mnuSearch);
        if (item == null) return;

        SearchView searchView = (SearchView) item.getActionView();
        if (searchView == null) {
            M.log("search view is null");
            return;
        }

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().findViewById(R.id.lblTitle) != null) {
                    getActivity().findViewById(R.id.lblTitle).setVisibility(View.GONE);
                }
            }
        });


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if (getActivity().findViewById(R.id.lblTitle) != null) {
                    getActivity().findViewById(R.id.lblTitle).setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mChkAroundMe.setChecked(true);

        mSwipeView.setAdapter(new SwipeAdapter(null, getActivity()));
        mSwipeView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mSwipeView);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng kollam = new LatLng(8.8932, 76.6141);
        googleMap.addMarker(new MarkerOptions().position(kollam).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.ic_location_on_48)));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(kollam, 14);
        googleMap.animateCamera(cameraUpdate);
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.addCircle(
                new CircleOptions()
                        .center(kollam)
                        .radius(1500)
                        .strokeWidth(0)
                        .fillColor(ContextCompat.getColor(getActivity(),
                                R.color.colorPrimaryTransparent)));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //inner classes

    private class SofoClusterRender extends DefaultClusterRenderer<ClusterItemBase> {

        private final IconGenerator mClusterIconGenerator;

        private RequestOptions mRequestOptions;


        public SofoClusterRender(Context context, GoogleMap map, ClusterManager<ClusterItemBase> clusterManager) {
            super(context, map, clusterManager);
            mClusterIconGenerator = new IconGenerator(context);
            @SuppressLint("InflateParams")
            View multiProfile = getLayoutInflater().inflate(R.layout.extra_letter_pin, null);
            mClusterIconGenerator.setBackground(null);
            mClusterIconGenerator.setContentView(multiProfile);
            mRequestOptions = new RequestOptions()
                    .centerCrop()
                    .override(75, 75)
                    .transform(new BitmapToPinExtension(String.valueOf(System.currentTimeMillis())));
        }

    }
}
