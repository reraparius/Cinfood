package com.example.cinfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // membuat objek view
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button edtprofil = view.findViewById(R.id.edit_profile);
        Button almt = view.findViewById(R.id.alamat);
        Button logout = view.findViewById(R.id.logout);

        //membuat cation pada button edit profile
        edtprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), editprofile.class);
                startActivity(intent);
            }
        });
        almt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), editprofile.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), editprofile.class);
                startActivity(intent);
            }
        });
        return view;
    }
}