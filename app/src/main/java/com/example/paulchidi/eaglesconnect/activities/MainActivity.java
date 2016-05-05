package com.example.paulchidi.eaglesconnect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.paulchidi.eaglesconnect.EagleKinvey;
import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.fragments.ArchiveFragment;
import com.example.paulchidi.eaglesconnect.fragments.ContactsFragment;
import com.example.paulchidi.eaglesconnect.fragments.ForumFragment;
import com.example.paulchidi.eaglesconnect.fragments.HelpFragment;
import com.example.paulchidi.eaglesconnect.fragments.MainFragment;
import com.kinvey.android.Client;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    protected TextView tvUsername;

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Client EagleUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EagleUser = ((EagleKinvey) getApplication()).getmKinveyClient();


        //Set the fragment initially
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        //How to change elements in the header programatically


        navigationView.setNavigationItemSelectedListener(this);


        if (EagleUser.user().isUserLoggedIn()) {
            String user = EagleUser.user().getUsername();

            View headerView = navigationView.getHeaderView(0);
            TextView emailText = (TextView) headerView.findViewById(R.id.email);
            emailText.setText("Class of 2015");
            tvUsername = (TextView) headerView.findViewById(R.id.username);


            tvUsername.setText(user);
        } else {
            Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intentLogin);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_edit_contacts) {
            Intent intentEditContacts = new Intent(this, EditContactsActivity.class);
            startActivity(intentEditContacts);

        }








        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //Set the fragment initially
            MainFragment fragment = new MainFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            // Handle the camera action
        } else if (id == R.id.nav_profile) {
            //Set the fragment initially
           /* ClassFragment fragment = new ClassFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
*/
        } else if (id == R.id.nav_yearbook) {

            Intent intentYearbook = new Intent(this, YearBookActivity.class);
            startActivity(intentYearbook);
        } else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_contacts) {
            ContactsFragment fragment = new ContactsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_help) {
            HelpFragment fragment = new HelpFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        } else if (id == R.id.nav_archive) {
            ArchiveFragment fragment = new ArchiveFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        } else if (id == R.id.nav_forum) {
            ForumFragment fragment = new ForumFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        } else if (id == R.id.nav_logout) {
            //Logging out the user
            EagleUser.user().logout().execute();
            boolean currentUser = EagleUser.user().isUserLoggedIn();
            if (currentUser == false) {
                Intent intentLogin = new Intent(MainActivity.this, LoginActivity.class);
                intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentLogin);
            } else {

            }


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
