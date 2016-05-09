package com.example.paulchidi.eaglesconnect.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.GridView;

import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.custom.MainAdapter;

import java.util.ArrayList;

public class MainBookActivity extends AppCompatActivity {
    public static String[] nameList = {"Yomi adedeji", "Emanuella Ekpoki", "Naomi Ekpoki",
            "Fadugba Muyiwa", "Eze Azubuike", "Abayomi Issac"

    };
    public static int[] images = {R.drawable.avatar_empty, R.drawable.avatar_empty, R.drawable.avatar_empty,
            R.drawable.avatar_empty, R.drawable.avatar_empty, R.drawable.avatar_empty,};
    protected GridView gvYearbook;
    Context context;
    ArrayList names;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_book);
        gvYearbook = (GridView) findViewById(R.id.gridView_mainbook);
        gvYearbook.setAdapter(new MainAdapter(this, nameList, images));

    }

}
