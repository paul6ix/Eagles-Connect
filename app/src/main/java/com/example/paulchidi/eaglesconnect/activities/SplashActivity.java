package com.example.paulchidi.eaglesconnect.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.paulchidi.eaglesconnect.R;
import com.parse.ParseUser;


public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(5 * 1000);
                    //After splash Display it logs in to the app
                    ParseUser currentUser = ParseUser.getCurrentUser();
                    if (currentUser != null) {
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


