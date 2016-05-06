package com.example.paulchidi.eaglesconnect.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.paulchidi.eaglesconnect.R;

public class EliteActivity extends AppCompatActivity {
    ImageView ivEliteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elite);
        ivEliteIcon = (ImageView) findViewById(R.id.imageView_elite);
        ivEliteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EliteActivity.this, WebViewActivity.class);
                intent.setData(Uri.parse("http://www.graddayphotos.com/"));
                startActivity(intent);
            }
        });
    }
}
