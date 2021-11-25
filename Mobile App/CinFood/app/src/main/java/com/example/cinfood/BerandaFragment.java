package com.example.cinfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BerandaFragment extends AppCompatActivity {

    private TextView makan, minum, FF;
    private EditText cari;
    private ImageView menuMakan, menuMinum, menuFF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_beranda);

        makan = findViewById(R.id.makan);
        minum = findViewById(R.id.minum);
        cari = findViewById(R.id.cari);
        FF = findViewById(R.id.FF);
        menuFF = findViewById(R.id.menuFF);
        menuMakan = findViewById(R.id.menuMakan);
        menuMinum = findViewById(R.id.menuMinum);

        makan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        menuMinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        menuMakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        menuFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        minum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });

        FF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BerandaFragment.this, Pencarian.class);
                startActivity(i);
            }
        });
    }
}
