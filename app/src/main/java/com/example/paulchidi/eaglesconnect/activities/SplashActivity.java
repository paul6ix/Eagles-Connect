package com.example.paulchidi.eaglesconnect.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.paulchidi.eaglesconnect.EagleKinvey;
import com.example.paulchidi.eaglesconnect.R;
import com.kinvey.android.Client;


public class SplashActivity extends Activity {
    Client CurrentEagleUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CurrentEagleUser = ((EagleKinvey) getApplication()).getmKinveyClient();

        setContentView(R.layout.activity_splash);
        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(1 * 1000);
                    //After splash Display it logs in to the app


                    if (CurrentEagleUser.user().isUserLoggedIn()) {
                        //if user has logged in before and session token is still active
                        Intent intentMain = new Intent(SplashActivity.this, MainActivity.class);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentMain);
                    } else {
                        //Asks user to login if session token has expired
                        Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
                        intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentLogin);
                    }


                } catch (Exception e) {
                    //
                }
            }
        };
        splash.start();

    }


}


