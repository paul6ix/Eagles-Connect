package com.example.paulchidi.eaglesconnect;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Paul Chidi on 3/1/2016.
 */
public class EagleParse extends Application {
    public void onCreate() {
        super.onCreate();

            Parse.initialize(this, "5Zz7ZKLLvqhIu2Ud5m73LrpVv1tKu7uJItJuHu9J", "UOkZPXCxwODcR22UeQZgDaUWvlU3tbDULoFDVqpf");

    }
}
