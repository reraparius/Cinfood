package com.example.cinfood.Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinfood.R;


public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // membuat objek view
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //edit profile ni bos
        TextView tv_editprofile = view.findViewById(R.id.tv_editprofile);
        tv_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),editprofile.class);
                startActivity(intent);
            }
        });

        //Logout ni bos(masih kurang)

       return view;
    }
}