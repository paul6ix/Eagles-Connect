package com.example.paulchidi.eaglesconnect.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.paulchidi.eaglesconnect.ParseConstants;
import com.example.paulchidi.eaglesconnect.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class EditContactsActivity extends ListActivity {
    protected List<ParseUser> mUsers;
    protected ParseRelation<ParseUser> mFriendsRelation;
    protected ParseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contacts);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentUser = ParseUser.getCurrentUser();
        mFriendsRelation = mCurrentUser.getRelation(ParseConstants.Key_Friends_Relations);


        ParseQuery queryUsers = ParseUser.getQuery();
        queryUsers.orderByAscending(ParseConstants.Key_Username);
        queryUsers.setLimit(1000);
        queryUsers.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
                if (e == null) {
                    mUsers = users;
                    String[] username = new String[mUsers.size()];
                    int i = 0;
                    for (ParseUser user : mUsers) {
                        username[i] = user.getUsername();
                        i++;
                    }
                    ArrayAdapter adapter = new ArrayAdapter<String>(EditContactsActivity.this, android.R.layout.simple_list_item_checked, username);
                    setListAdapter(adapter);
                    addFriendCheckmarks();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditContactsActivity.this);
                    builder.setMessage(e.getMessage())
                            .setTitle("Information")
                            .setPositiveButton(android.R.string.ok, null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }


        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if (getListView().isItemChecked(position)) {
            super.onListItemClick(l, v, position, id);
            mFriendsRelation.add(mUsers.get(position));

        } else {
            mFriendsRelation.remove(mUsers.get(position));
        }
        mCurrentUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {

            }
        });

    }

    private void addFriendCheckmarks() {
        mFriendsRelation.getQuery().findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> friends, ParseException e) {
                if (e == null) {
                    // list returned - look for a match
                    for (int i = 0; i < mUsers.size(); i++) {
                        ParseUser user = mUsers.get(i);

                        for (ParseUser friend : friends) {
                            if (friend.getObjectId().equals(user.getObjectId())) {
                                getListView().setItemChecked(i, true);
                            }
                        }
                    }
                } else {
                    Log.e("message", e.getMessage());
                }
            }
        });
    }
}
