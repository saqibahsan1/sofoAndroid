package com.twixttechnologies.sofo.view.contacts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.twixttechnologies.sofo.R;
import com.twixttechnologies.sofo.adapter.list.ContactsAdapter;
import com.twixttechnologies.sofo.adapter.list.ContactsAdapter2;
import com.twixttechnologies.sofo.utils.M;
import com.twixttechnologies.sofo.view.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Sony Raj on 14/12/17.
 */

public class ContactsFragment extends BaseFragment {

    @BindView(R.id.lstPinnedContacts)
    RecyclerView mLstPinnedContacts;
    @BindView(R.id.lstRecentContacts)
    RecyclerView mLstRecentContacts;
    @BindView(R.id.lstContacts)
    RecyclerView mLstContacts;
    Unbinder unbinder;

    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.mnuSearch);
        if (item ==null) return;

        SearchView searchView = (SearchView) item.getActionView();
        if (searchView == null){
            M.log("search view is null");
            return;
        }

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity().findViewById(R.id.lblTitle) != null){
                    getActivity().findViewById(R.id.lblTitle).setVisibility(View.GONE);
                }
            }
        });


        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if (getActivity().findViewById(R.id.lblTitle) != null){
                    getActivity().findViewById(R.id.lblTitle).setVisibility(View.VISIBLE);
                }
                return false;
            }
        });


        /*item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return false;
            }
        });*/
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLstPinnedContacts.setAdapter(new ContactsAdapter(null, getActivity()));
        mLstPinnedContacts.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        mLstRecentContacts.setAdapter(new ContactsAdapter(null, getActivity()));
        mLstRecentContacts.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<String> myDataset = new ArrayList<String>();
        for (int i = 0; i < 26; i++) {
            myDataset.add(Character.toString((char) (65 + i)) + " Row item");
        }

        mLstContacts.setAdapter(new ContactsAdapter2(myDataset, getActivity()));
        mLstContacts.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
