package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;

import java.util.List;

/**
 * @author Sony Raj on 14/12/17.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private final Context context;
    private List<Object> items;

    public ContactsAdapter(List<Object> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_pinned_contact, parent, false);
        return new ContactsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 10;
        }
        return items.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {


        ContactsViewHolder(View itemView) {
            super(itemView);
        }

    }

}