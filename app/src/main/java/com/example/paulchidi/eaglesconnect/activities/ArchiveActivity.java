package com.example.paulchidi.eaglesconnect.activities;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.custom.ImageAndTextItem;
import com.example.paulchidi.eaglesconnect.custom.ListAdapter;

import java.util.ArrayList;

public class ArchiveActivity extends AppCompatActivity {

    /*

        BEFORE YOU ADD THIS CODE, MAKE SURE YOU HAVE A ListAdapter created
        AND A LAYOUT FOR YOUR ROW.

        (see ListAdapter class and list_item_with_image.xml)
     */


    // The first step to populating a list item
    // is to create an object to store data that
    // will be use for each row in the list.
    private ArrayList<ImageAndTextItem> listViewItems;

    // Next, we'll want to create a reference to
    // our List Adapter.  We'll pass our current
    // activity as 'this' and the object we just
    // created to store our items called 'listViewItems'
    private ListAdapter listAdapter = new ListAdapter(this, listViewItems);

    // We want this available throughout this class
    // so we'll declare our myBasicListView object
    // here.
    private ListView myImageListView;

    private void setupListViewItems() {
        listViewItems.add(new ImageAndTextItem(R.drawable.image1, "Public Lectures"));
        listViewItems.add(new ImageAndTextItem(R.drawable.image2, "Eagles Submit"));
        listViewItems.add(new ImageAndTextItem(R.drawable.image3, "Chapel Messages"));
        listViewItems.add(new ImageAndTextItem(R.drawable.image4, "Chop Messages"));
        listViewItems.add(new ImageAndTextItem(R.drawable.image5, "Shiloh Messages"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_archive);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        listViewItems = new ArrayList<ImageAndTextItem>();

        setupListViewItems();

        // Now that we've got 5 records to display, let's take our ArrayList
        // and assign it to the adapter class that we prepared an ArrayList for.
        listAdapter.list = listViewItems;

        // Let's find our myBasicListView item and set the variable we declared above
        // so we can populate the data later.
        myImageListView = (ListView) findViewById(R.id.listView);

        // Next, we'll assign our ListAdapter class ('listAdapter') to
        // our myBasicListView adapter property.
        myImageListView.setAdapter(listAdapter);

        // Now, how do we handle 'touch' events, you say?  Well, surprisingly
        // it's not a touch event, but it's an OnItemClick event.
        // You don't have to memorize this code, but you should note a quick
        // shortcut where you can type new OnClickLi and then pressing Tab on your keyboard
        // should generate the @Override event.
        myImageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=covenant+university+public+lecture"));
                    startActivity(intent);
                }
                if (position == 1) {

                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/channel/UCvgX_gv2EasAGjh9mrwA3QA/"));
                    startActivity(intent);

                }
                if (position == 2) {
                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=winners+chapel+sunday+services"));
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=covenant+hour+of+prayer"));
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=covenant+hour+of+prayer"));
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(ArchiveActivity.this, WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.youtube.com/results?search_query=shiloh+messages"));
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;

        }
        else  if (id == android.R.id.home){
            onBackPressed();
        }
        else if (id == R.id.action_edit_contacts) {
            Intent intentEditContacts = new Intent(this, EditContactsActivity.class);
            startActivity(intentEditContacts);

        } else if (id == R.id.action_notify) {
            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notify = new NotificationCompat.Builder(ArchiveActivity.this);
            notify.setContentTitle("New Message");
            notify.setContentText("Fadugba Messaged You");
            notify.setSound(sound);
            notify.setContentIntent(pendingIntent);
            notify.setSmallIcon(R.drawable.logo);

            Notification notification = notify.build();
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(5566, notification);


        }
        return super.onOptionsItemSelected(item);
    }
}
