package com.example.paulchidi.eaglesconnect.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.GridView;

import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.custom.CustomAdapter;

import java.util.ArrayList;

public class YearBookActivity extends AppCompatActivity {
    public static String[] nameList = {"2015", "2014", "2013",
            "2012", "2011", "2010"

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
        setContentView(R.layout.activity_year_book);
        gvYearbook = (GridView) findViewById(R.id.gridView_yearbook);
        gvYearbook.setAdapter(new CustomAdapter(this, nameList, images));

    }
}
