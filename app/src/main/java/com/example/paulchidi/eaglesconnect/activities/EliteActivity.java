package com.example.paulchidi.eaglesconnect.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.paulchidi.eaglesconnect.R;

public class EliteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elite);


        Thread redirect = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5 * 1000);
                    Intent intent = new Intent(EliteActivity.this, MainBookActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } catch (Exception e) {
                    Log.e("App error", e.getMessage());


                }
            }

        };
        redirect.start();


    }
}
