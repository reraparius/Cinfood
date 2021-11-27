package com.example.cinfood;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class BerandaFragment extends Fragment {


    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        TextView makan = view.findViewById(R.id.makan);
        TextView minum = view.findViewById(R.id.minum);
        TextView FF = view.findViewById(R.id.FF);
        ImageView menuFF = view.findViewById(R.id.menuFF);
        EditText cari = view.findViewById(R.id.cari);
        ImageView menuMakan = view.findViewById(R.id.menuMakan);
        ImageView menuMinum = view.findViewById(R.id.menuMinum);

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

        FF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });

        menuFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });

        menuMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });

        menuMinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pencarian.class);
                startActivity(i);
            }
        });
        return view;
    }
}