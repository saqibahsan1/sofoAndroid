package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.twixttechnologies.sofo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sony Raj on 14/12/17.
 */
public class FeaturedAroundAdapter extends RecyclerView.Adapter<FeaturedAroundAdapter.Featured> {
    private final Context context;
    private List<Object> items;
    private RequestManager mRequestManager;
    private RequestOptions requestOptions;

    public FeaturedAroundAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
        requestOptions = new RequestOptions().centerCrop().transform(new RoundedCorners(25));
        mRequestManager = Glide.with(context).applyDefaultRequestOptions(requestOptions);
    }

    @Override
    public Featured onCreateViewHolder(ViewGroup parent,
                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_dashboard_featured_item, parent, false);
        return new Featured(v);
    }

    @Override
    public void onBindViewHolder(Featured holder, int position) {
        mRequestManager.load(R.drawable.image)
                .apply(requestOptions)
                .into(holder.mImgFeatured);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 10;
        }
        return items.size();
    }

    class Featured extends RecyclerView.ViewHolder {

        @BindView(R.id.imgFeatured)
        AppCompatImageView mImgFeatured;
        @BindView(R.id.lblLocationName)
        AppCompatTextView mLblLocationName;

        Featured(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}