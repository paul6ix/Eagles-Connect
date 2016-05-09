package com.example.paulchidi.eaglesconnect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paulchidi.eaglesconnect.EagleKinvey;
import com.example.paulchidi.eaglesconnect.R;
import com.kinvey.android.Client;


/**
 * A simple {@link } subclass.
 */
public class ProfileFragment extends Fragment {
    TextView tvName;
    Client Kinveyclient;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
       tvName = (TextView) rootView.findViewById(R.id.textView_name);



        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}