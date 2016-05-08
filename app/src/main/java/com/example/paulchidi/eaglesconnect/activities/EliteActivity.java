package com.example.paulchidi.eaglesconnect.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.paulchidi.eaglesconnect.R;

public class EliteActivity extends AppCompatActivity {
    ImageView ivEliteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elite);

        ivEliteIcon = (ImageView) findViewById(R.id.imageView_welcome);

        TranslateAnimation animation = new TranslateAnimation(0.0f, 400.0f,
                0.0f, 0.0f);
        animation.setDuration(5000);
        animation.setRepeatCount(5);
        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        ivEliteIcon.startAnimation(animation);
        Thread redirect = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5*1000);
                    Intent intent = new Intent(EliteActivity.this,WebViewActivity.class);
                    intent.setData(Uri.parse("https://www.google.com"));
                    startActivity(intent);

                }
                catch (Exception e){
                    AlertDialog.Builder builder =  new AlertDialog.Builder(EliteActivity.this);
                    builder.setMessage(e.getMessage());
                    builder.setTitle("Error");
                    builder.create().show();

                }
            }

        };
redirect.start();


    }
}
