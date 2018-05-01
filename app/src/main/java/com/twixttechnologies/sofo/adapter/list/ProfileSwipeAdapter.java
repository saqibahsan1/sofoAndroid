package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.profile.ProfileDetailActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sony Raj on 11/1/18.
 */
public class ProfileSwipeAdapter extends RecyclerView.Adapter<ProfileSwipeAdapter.SwipeViewHolder> {
    private final Context context;
    private List<Object> items;

    public ProfileSwipeAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public SwipeViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_swipe_profile, parent, false);
        return new SwipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SwipeViewHolder holder, int position) {
        //TODO Fill in your logic for binding the view.
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 20;
        }
        return items.size();
    }


    class SwipeViewHolder extends RecyclerView.ViewHolder {

        SwipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btnConnect)
        public void onViewClicked() {
            context.startActivity(new Intent(context, ProfileDetailActivity.class));
        }


        @OnClick
        public void onClick() {
            /*Intent detail = new Intent(context, LocationDetailActivity.class);
            detail.putExtra("lat", 8.8932);
            detail.putExtra("lng", 76.6141);
            context.startActivity(detail);
            ((AppCompatActivity) context).overridePendingTransition(R.anim.left_in, R.anim.right_out);*/
        }

    }

}