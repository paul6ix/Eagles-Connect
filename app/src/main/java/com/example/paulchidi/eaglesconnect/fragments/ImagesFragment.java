package com.example.paulchidi.eaglesconnect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.paulchidi.eaglesconnect.R;


/**
 * A simple {@link } subclass.
 */
public class ImagesFragment extends Fragment {
    TextView tvName;
    TextView btnBio;
    TextView btnImages;
    TextView btnOther;
    ImageSwitcher switcher;
    ImageButton btnNext, btnPrev;


    public ImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_images, container, false);
        btnBio = (TextView) rootView.findViewById(R.id.textbutton_bio);
        btnImages = (TextView) rootView.findViewById(R.id.textbutton_images);
        btnOther = (TextView) rootView.findViewById(R.id.textbutton_other);
        switcher = (ImageSwitcher) rootView.findViewById(R.id.imageSwitcher);
        btnNext = (ImageButton) rootView.findViewById(R.id.imageButton_next);
        btnPrev = (ImageButton) rootView.findViewById(R.id.imageButton_prev);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);
        switcher.setImageResource(R.drawable.cuimg);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switcher.setImageResource(R.drawable.omi_p);
                Toast.makeText(getActivity(), "Next image", Toast.LENGTH_SHORT).show();

            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switcher.setImageResource(R.drawable.alumni);
                Toast.makeText(getActivity(), "Previous image", Toast.LENGTH_SHORT).show();

            }
        });

        btnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BioFragment fragment = new BioFragment();
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



