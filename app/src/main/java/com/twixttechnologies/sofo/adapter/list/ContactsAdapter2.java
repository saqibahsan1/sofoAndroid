package com.twixttechnologies.sofo.adapter.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l4digital.fastscroll.FastScroller;
import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.view.message.ChatActivity;

import java.text.MessageFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author Sony Raj on 14/12/17.
 */
public class ContactsAdapter2 extends RecyclerView.Adapter<ContactsAdapter2.ContactsViewHolder2> implements FastScroller.SectionIndexer {
    private final Context context;
    private List<String> items;

    public ContactsAdapter2(List<String> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ContactsViewHolder2 onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.extra_contact_item, parent, false);
        return new ContactsViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder2 holder, int position) {
        holder.mLblContactName.setText(MessageFormat.format("@{0}", items.get(position)));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 10;
        }
        return items.size();
    }

    @Override
    public String getSectionText(int position) {
        return items.get(position).substring(0,1);
    }

    class ContactsViewHolder2 extends RecyclerView.ViewHolder {
        
        @BindView(R.id.imgContact)
        CircleImageView mImgContact;
        @BindView(R.id.lblContactName)
        AppCompatTextView mLblContactName;
        @BindView(R.id.btnMessage)
        AppCompatImageButton mBtnMessage;

        ContactsViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btnMessage)
        public void onclick() {
            context.startActivity(new Intent(context, ChatActivity.class));
            ((AppCompatActivity) context).overridePendingTransition(R.anim.right_in,R.anim.left_out);
        }

    }

}