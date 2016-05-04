package com.example.paulchidi.eaglesconnect.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.paulchidi.eaglesconnect.R;
import com.example.paulchidi.eaglesconnect.activities.CreateForumActivity;


/**
 * A simple {@link } subclass.
 */
public class ForumFragment extends Fragment {
    protected Button btnNewForum;



    public ForumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_forum, container, false);
        btnNewForum = (Button) rootView.findViewById(R.id.button_new_forum);
        btnNewForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getActivity(), CreateForumActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}