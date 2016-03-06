package com.example.paulchidi.eaglesconnect;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Paul Chidi on 3/1/2016.
 */
public class EagleParse extends Application {
    public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "EPLDczZ4dS5vHJPQKKQbKmlC096JMf6gVtzTbqOs", "UD9qZuBfC2s72egfedTlWIvN0i4nxZeGdw1WSpMB");
    }
}
