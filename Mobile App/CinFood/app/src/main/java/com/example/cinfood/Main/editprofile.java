package com.example.cinfood.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.cinfood.R;
import com.google.android.material.textfield.TextInputEditText;

public class editprofile extends AppCompatActivity {

     public static String id_user, nama, tgl_lahir, no_hp, alamat, email_user, password_data;

    TextInputEditText txt_nama_lengkap, txt_tgl_lahir, txt_alamat, txt_no_telp, txt_Email, txt_password;
    TextView txt_id;

    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        System.out.println(nama);

        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_tgl_lahir = findViewById(R.id.txt_tgl_lahir);
        txt_alamat = findViewById(R.id.txt_alamat);
        txt_no_telp = findViewById(R.id.txt_no_telp);
        txt_Email = findViewById(R.id.txt_Email);
        txt_password = findViewById(R.id.txt_password);
        txt_id = findViewById(R.id.txt_id);

         // set data field
        txt_id.setText(id_user);
        txt_nama_lengkap.setText(nama);
        txt_tgl_lahir.setText(tgl_lahir);
        txt_alamat.setText(alamat);
        txt_no_telp.setText(no_hp);
        txt_Email.setText(email_user);
        txt_password.setText(password_data);


       // btn_simpan = findViewById(R.id.btn_edit_profile);
    }
}