package com.example.cinfood.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cinfood.API.ApiClient;
import com.example.cinfood.API.ApiInterface;
import com.example.cinfood.Model.RequestData;
import com.example.cinfood.R;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class editprofile extends AppCompatActivity {

     public static String  nama, tgl_lahir, no_hp, alamat, email_user, password_data;
    public static int id_user;
    String  Nama, TGL, NOHP, Alamat, Email, Password;
    TextInputEditText txt_nama_lengkap, txt_tgl_lahir, txt_alamat, txt_no_telp, txt_Email, txt_password;
    TextView txt_id;
    ApiInterface apiInterface;

    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        System.out.println(nama);
        System.out.println(id_user);

        txt_nama_lengkap = findViewById(R.id.txt_nama_lengkap);
        txt_tgl_lahir = findViewById(R.id.txt_tgl_lahir);
        txt_alamat = findViewById(R.id.txt_alamat);
        txt_no_telp = findViewById(R.id.txt_no_telp);
        txt_Email = findViewById(R.id.txt_Email);
        txt_password = findViewById(R.id.txt_password);
       // txt_id = findViewById(R.id.txt_id);

         // set data field
     //   txt_id.setText(id_user);
        txt_nama_lengkap.setText(nama);
        txt_tgl_lahir.setText(tgl_lahir);
        txt_alamat.setText(alamat);
        txt_no_telp.setText(no_hp);
        txt_Email.setText(email_user);
        txt_password.setText(password_data);

        btn_simpan = findViewById(R.id.btnSimpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Nama = txt_nama_lengkap.getText().toString();
                TGL = txt_tgl_lahir.getText().toString();
                NOHP = txt_no_telp.getText().toString();
                Alamat = txt_alamat.getText().toString();
                Email = txt_Email.getText().toString();
                Password = txt_password.getText().toString();

                UpdateData(id_user,Nama,TGL, NOHP, Alamat,Email,Password);

            }
        });
    }

     private void UpdateData(int id, String nm, String tgl,String nohp, String almt, String eml, String pswd){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
         Call<RequestData> update = apiInterface.UpdateData(id, nm, tgl, nohp, almt, eml,pswd);
         update.enqueue(new Callback<RequestData>() {
             @Override
             public void onResponse(Call<RequestData> call, Response<RequestData> response) {
                 if(response.body().isStatus() == true){
                   Toast.makeText(editprofile.this, "Alhamdulillah", Toast.LENGTH_SHORT).show();

                   finish();

                    } else {
                        Toast.makeText(editprofile.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
             }

             @Override
             public void onFailure(Call<RequestData> call, Throwable t) {
                  Toast.makeText(editprofile.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

             }
         });
     }
}