package com.twixttechnologies.sofo.adapter.list;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.location.LocationDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * @author Sony Raj on 14/12/17.
 */
public class DashboardLocationAdapter extends RecyclerView.Adapter<DashboardLocationAdapter.Location> {
    private final Context context;
    private List<Object> items;


    private PeopleAdapter mPeopleAdapter;

    public DashboardLocationAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
        mPeopleAdapter = new PeopleAdapter(null, context);
    }

    @Override
    public Location onCreateViewHolder(ViewGroup parent,
                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_dashboard_place, parent, false);
        return new Location(v);
    }

    @Override
    public void onBindViewHolder(Location holder, int position) {
        //TODO Fill in your logic for binding the view.
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 10;
        }
        return items.size();
    }

    @Override
    public void onViewAttachedToWindow(Location holder) {
        super.onViewAttachedToWindow(holder);
        holder.mLtPeopleContainer.setVisibility(View.GONE);
    }

    class Location extends RecyclerView.ViewHolder {

        @BindView(R.id.lstPeople)
        RecyclerView mLstPeople;
        @BindView(R.id.ltPeopleContainer)
        LinearLayout mLtPeopleContainer;

        Location(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mLstPeople.setAdapter(mPeopleAdapter);
            mLstPeople.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        }

        @OnClick
        public void onClick(){
            context.startActivity(new Intent(context, LocationDetailActivity.class));
        }

        @Optional
        @OnClick(R.id.btnPeople)
        public void onPeopleClicked() {
            mLtPeopleContainer.setTranslationX(1000);
            mLtPeopleContainer.setVisibility(View.VISIBLE);
            ObjectAnimator animator = ObjectAnimator.ofFloat(mLtPeopleContainer,View.TRANSLATION_X,1000,0);
            animator.setDuration(500);
            animator.setInterpolator(new OvershootInterpolator(1.2f));
            animator.start();
        }

        @Optional
        @OnClick(R.id.btnClosePeople)
        public void onPeopleCloseClicked() {
            ObjectAnimator animator = ObjectAnimator.ofFloat(mLtPeopleContainer,View.TRANSLATION_X,0,1000);
            animator.setDuration(400);
            animator.start();
        }
    }


}