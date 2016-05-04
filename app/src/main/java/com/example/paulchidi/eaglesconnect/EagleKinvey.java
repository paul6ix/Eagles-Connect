package com.example.paulchidi.eaglesconnect;

import android.app.Application;
import android.util.Log;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;
import com.parse.Parse;


/**
 * Created by Paul Chidi on 3/1/2016.
 */
public class EagleKinvey extends Application {
    public static final String eagles_app_key = "kid_b168D4AefW";
    public static final String eagles_app_secret = "b273dfc47e934a8cb445c12893e1ddd9";
    protected Client mKinveyClient;
    String TAG;

    public void onCreate() {
        super.onCreate();


        Parse.initialize(this, "EPLDczZ4dS5vHJPQKKQbKmlC096JMf6gVtzTbqOs", "UD9qZuBfC2s72egfedTlWIvN0i4nxZeGdw1WSpMB");
        loadService();
        mKinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e(TAG, "Kinvey Ping Failed", t);
            }

            public void onSuccess(Boolean b) {
                Log.d(TAG, "Kinvey Ping Success");
            }
        });
    }

    public void loadService() {
        mKinveyClient = new Client.Builder(eagles_app_key, eagles_app_secret
                , this.getApplicationContext()).build();

    }

    public Client getmKinveyClient() {
        return mKinveyClient;
    }

}
