package com.example.paulchidi.eaglesconnect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paulchidi.eaglesconnect.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends ListFragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        // Inflate the layout for this fragment
        return rootView;
    }


}
