package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;

import java.util.List;

/**
 * @author Sony Raj on 2/1/18.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private final Context context;
    private List<Object> items;

    public PeopleAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_people_item, parent, false);
        return new PeopleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 10;
        }
        return items.size();
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder {


        PeopleViewHolder(View itemView) {
            super(itemView);
        }

    }

}