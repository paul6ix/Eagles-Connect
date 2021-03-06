package com.example.paulchidi.eaglesconnect.fragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.paulchidi.eaglesconnect.Chat;
import com.example.paulchidi.eaglesconnect.ParseConstants;
import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.utils.UserAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
    public static final String TAG = ContactsFragment.class.getSimpleName();
    public static ParseUser mCurrentUser;
    protected ParseRelation<ParseUser> mFriendsRelation;
    protected List<ParseUser> mFriends;
    protected GridView gvContacts;



    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
        gvContacts = (GridView) rootView.findViewById(R.id.gridview_contacts);


        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        mCurrentUser = ParseUser.getCurrentUser();
        mFriendsRelation = mCurrentUser.getRelation(ParseConstants.Key_Friends_Relations);

        getActivity().setProgressBarIndeterminateVisibility(true);

        ParseQuery<ParseUser> query = mFriendsRelation.getQuery();
        query.addAscendingOrder(ParseConstants.Key_Username);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> friends, ParseException e) {
                getActivity().setProgressBarIndeterminateVisibility(false);

                if (e == null) {
                    mFriends = friends;

                    String[] usernames = new String[mFriends.size()];
                    int i = 0;
                    for (ParseUser user : mFriends) {
                        usernames[i] = user.getUsername();
                        i++;
                    }
//                    if (gvContacts.getAdapter() == null) {
                    UserAdapter adapter = new UserAdapter(getActivity(), mFriends);
                    gvContacts.setAdapter(adapter);
//                    } else {
//                        ((UserAdapter) gvContacts.getAdapter()).refill(mFriends);
//                    }

                } else {
                    Log.e(TAG, e.getMessage());
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage(e.getMessage())
                            .setTitle("Error")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        gvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentChat = new Intent(getActivity(), Chat.class);
                intentChat.putExtra(ParseConstants.EXTRA_DATA, mFriends.get(position).getUsername());
                startActivity(intentChat);
            }
        });

    }


   /* @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intentChat = new Intent(getActivity(), Chat.class);
        intentChat.putExtra(ParseConstants.EXTRA_DATA, mFriends.get(position).getUsername());
        startActivity(intentChat);


    }*/
}
