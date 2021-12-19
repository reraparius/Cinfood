package com.example.cinfood.Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.cinfood.R;


public class BerandaFragment extends Fragment {


    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        CardView makan = view.findViewById(R.id.makan);
        CardView minum = view.findViewById(R.id.minum);
        EditText cari = view.findViewById(R.id.cari);

        makan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Pencarian.class);
                startActivity(intent);
            }
        });

        minum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });

        return view;
    }
}