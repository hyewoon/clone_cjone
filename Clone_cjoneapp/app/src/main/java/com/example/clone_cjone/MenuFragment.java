package com.example.clone_cjone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class MenuFragment extends Fragment {

    ImageView close, home, search, alarm, setting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);


        close = v.findViewById(R.id.close);
        home = v.findViewById(R.id.home);
        search = v.findViewById(R.id.search);
        alarm = v.findViewById(R.id.alarm);
        setting = v.findViewById(R.id.setting);

        return v;
    }
}