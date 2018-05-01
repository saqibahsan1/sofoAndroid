package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * @author Sony Raj on 18/12/17.
 */
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder> {
    private final Context context;

    private List<Integer> items;

    private OnButtonInteractionListener mListener;

    public FeedsAdapter(List<Integer> items, Context context,
                        OnButtonInteractionListener listener) {
        this.items = items;
        this.context = context;
        mListener = listener;
    }

    @Override
    public FeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new FeedsViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return  R.layout.extra_user_profile_item;
    }

    @Override
    public void onBindViewHolder(FeedsViewHolder holder, int position) {
        position = items.get(position);
        if (position % 2 == 0) {
            holder.mImgFeedLarge.setVisibility(View.VISIBLE);
        } else if (position % 3 == 0) {
            holder.mImgFeedLarge.setVisibility(View.VISIBLE);
            holder.mLblFeedText.setVisibility(View.VISIBLE);
        } else if (position % 4 == 0) {
            holder.mLblFeedText.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallOne.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallTwo.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallThree.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallFour.setVisibility(View.VISIBLE);
        } else if (position % 5 == 0) {
            holder.mImgFeedLarge.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallOne.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallTwo.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallThree.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallFour.setVisibility(View.VISIBLE);
        } else {
            holder.mLblFeedText.setVisibility(View.VISIBLE);
            holder.mImgFeedLarge.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallOne.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallTwo.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallThree.setVisibility(View.VISIBLE);
            holder.mImgFeedSmallFour.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onViewDetachedFromWindow(FeedsViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder.mLblFeedText != null) {
            holder.mLblFeedText.setVisibility(View.GONE);
        }
        if (holder.mImgFeedLarge != null) {
            holder.mImgFeedLarge.setVisibility(View.GONE);
        }
        if (holder.mImgFeedSmallOne != null) {
            holder.mImgFeedSmallOne.setVisibility(View.GONE);
        }
        if (holder.mImgFeedSmallTwo != null) {
            holder.mImgFeedSmallTwo.setVisibility(View.GONE);
        }
        if (holder.mImgFeedSmallThree != null) {
            holder.mImgFeedSmallThree.setVisibility(View.GONE);
        }
        if (holder.mImgFeedSmallFour != null) {
            holder.mImgFeedSmallFour.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 15;
        }
        return items.size();
    }


    class FeedsViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        @BindView(R.id.imgFeedPostedBy)
        AppCompatImageView mImgFeedPostedBy;
        @Nullable
        @BindView(R.id.lblPostedOn)
        AppCompatTextView mLblPostedOn;
        @Nullable
        @BindView(R.id.lblLikes)
        AppCompatTextView mLblLikes;
        @Nullable
        @BindView(R.id.lblFeedText)
        AppCompatTextView mLblFeedText;
        @Nullable
        @BindView(R.id.imgFeedLarge)
        AppCompatImageView mImgFeedLarge;
        @Nullable
        @BindView(R.id.imgFeedSmallOne)
        AppCompatImageView mImgFeedSmallOne;
        @Nullable
        @BindView(R.id.imgFeedSmallTwo)
        AppCompatImageView mImgFeedSmallTwo;
        @Nullable
        @BindView(R.id.imgFeedSmallThree)
        AppCompatImageView mImgFeedSmallThree;
        @Nullable
        @BindView(R.id.imgFeedSmallFour)
        AppCompatImageView mImgFeedSmallFour;

        @Nullable
        @BindView(R.id.btnInstagram)
        FloatingActionButton mBtnInstagram;

        FeedsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            if (mLblFeedText != null) {
                mLblFeedText.setVisibility(View.GONE);
            }
            if (mImgFeedLarge != null) {
                mImgFeedLarge.setVisibility(View.GONE);
            }
            if (mImgFeedSmallOne != null) {
                mImgFeedSmallOne.setVisibility(View.GONE);
            }
            if (mImgFeedSmallTwo != null) {
                mImgFeedSmallTwo.setVisibility(View.GONE);
            }
            if (mImgFeedSmallThree != null) {
                mImgFeedSmallThree.setVisibility(View.GONE);
            }
            if (mImgFeedSmallFour != null) {
                mImgFeedSmallFour.setVisibility(View.GONE);
            }
        }


        @Optional
        @OnClick(R.id.btnInstagram)
        public void onViewClicked() {
            mListener.onInstagram();
        }

    }

    public interface OnButtonInteractionListener {
        void onInstagram();
    }


}