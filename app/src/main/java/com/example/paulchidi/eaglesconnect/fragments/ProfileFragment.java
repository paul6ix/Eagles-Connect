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
   TextView btnBio;
    TextView btnImages;
    TextView btnOther;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
       tvName = (TextView) rootView.findViewById(R.id.textView_name);
        btnBio = (TextView) rootView.findViewById(R.id.textbutton_bio);
        btnImages = (TextView) rootView.findViewById(R.id.textbutton_images);
        btnOther = (TextView) rootView.findViewById(R.id.textbutton_other);
        btnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagesFragment fragment = new ImagesFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
      btnImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagesFragment fragment = new ImagesFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OtherFragment fragment = new OtherFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });



        return rootView;
    }


}