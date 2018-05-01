package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sony Raj on 14/12/17.
 */
public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private List<Object> items;

    private static final int TXT_LEFT = 1;
    private static final int TXT_RIGHT = 2;
    private static final int IMAGE_LEFT = 3;
    private static final int IMAGE_RIGHT = 4;

    private Random mRandom;

    public ChatAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
        mRandom = new Random(System.currentTimeMillis());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TXT_LEFT:
            case TXT_RIGHT:
                return new TextChat(inflater.inflate(R.layout.extra_chat_text, parent, false));

            case IMAGE_LEFT:
            case IMAGE_RIGHT:
                return new ImageChat(inflater.inflate(R.layout.extra_image_group, parent, false));
        }
        return new ImageChat(inflater.inflate(R.layout.extra_image_group, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        //return mRandom.nextInt(5) + 1;
        position = position + 1;
        return (position % 2 == 0 ? TXT_LEFT : IMAGE_LEFT);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        boolean left = mRandom.nextInt(2) + 1 == 1;
        if (holder instanceof TextChat) {
            if (left) {
                ((TextChat) holder).mTextLeft.setVisibility(View.VISIBLE);
                ((TextChat) holder).mTextRight.setVisibility(View.GONE);
            } else {
                ((TextChat) holder).mTextLeft.setVisibility(View.GONE);
                ((TextChat) holder).mTextRight.setVisibility(View.VISIBLE);
            }
        } else if (holder instanceof ImageChat) {
            if (left) {
                ((ImageChat) holder).mLtLeft.setVisibility(View.VISIBLE);
                ((ImageChat) holder).mLtRight.setVisibility(View.GONE);
            } else {
                ((ImageChat) holder).mLtRight.setVisibility(View.VISIBLE);
                ((ImageChat) holder).mLtLeft.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 50;
        }
        return items.size();
    }

    class TextChat extends RecyclerView.ViewHolder {

        @BindView(R.id.textLeft)
        AppCompatTextView mTextLeft;
        @BindView(R.id.textRight)
        AppCompatTextView mTextRight;

        public TextChat(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ImageChat extends RecyclerView.ViewHolder {

        @BindView(R.id.ltLeft)
        CardView mLtLeft;
        @BindView(R.id.ltRight)
        CardView mLtRight;

        public ImageChat(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}