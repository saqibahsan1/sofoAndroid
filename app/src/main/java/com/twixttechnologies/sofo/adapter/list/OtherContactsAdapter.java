package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.dialog.ProfileDialog;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Sony Raj on 14/12/17.
 */
public class OtherContactsAdapter extends RecyclerView.Adapter<OtherContactsAdapter.OtherContactsViewHolder> {
    private final Context context;
    private List<Object> items;

    public OtherContactsAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public OtherContactsViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_other_contacts, parent, false);
        return new OtherContactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(OtherContactsViewHolder holder, int position) {

        //TODO Fill in your logic for binding the view.
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 40;
        }
        return items.size();
    }

    class OtherContactsViewHolder extends RecyclerView.ViewHolder {


        OtherContactsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick
        public void onClick() {
            new ProfileDialog().show(((AppCompatActivity) context).getSupportFragmentManager(),
                    "profile");
        }


    }

}