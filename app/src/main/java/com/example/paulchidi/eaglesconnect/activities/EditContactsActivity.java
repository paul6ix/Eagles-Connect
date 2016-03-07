package com.example.paulchidi.eaglesconnect.activities;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.example.paulchidi.eaglesconnect.ParseConstants;
import com.example.paulchidi.eaglesconnect.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class EditContactsActivity extends ListActivity {
    protected List<ParseUser> mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contacts);
        getListView().setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        ParseQuery queryUsers = ParseUser.getQuery();
        queryUsers.orderByAscending(ParseConstants.Key_Username);
        queryUsers.setLimit(1000);
        queryUsers.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
                if (e == null) {
                    mUser = users;
                    String[] username = new String[mUser.size()];
                    int i = 0;
                    for (ParseUser user : mUser) {
                        username[i] = user.getUsername();
                        i++;
                    }
                    ArrayAdapter adapter = new ArrayAdapter<String>(EditContactsActivity.this, android.R.layout.simple_list_item_checked, username);
                    setListAdapter(adapter);


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

    public void actionBar() {
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
