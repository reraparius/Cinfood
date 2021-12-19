package com.example.cinfood.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinfood.API.ApiClient;
import com.example.cinfood.API.ApiInterface;
import com.example.cinfood.Model.RequestData;
import com.example.cinfood.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText edtnama, edtemail, edtpassword;
    Button btnRegister1;
    String Nama, Email, Password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        edtnama = findViewById(R.id.edtnama);
        edtemail = findViewById(R.id.edtemail);
        edtpassword = findViewById(R.id.edtpassword);
        btnRegister1 = findViewById(R.id.btnRegister1);

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnRegister1:
                        Nama = edtnama.getText().toString();
                        Email = edtemail.getText().toString();
                        Password = edtpassword.getText().toString();
                        register(Nama, Email, Password);
                        break;
                }
            }
        });
    }

    private void register(String namaLengkap, String email_user,String password ){
       apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RequestData> call = apiInterface.RegistResponse(namaLengkap, email_user,password);

        call.enqueue(new Callback<RequestData>() {
            @Override
            public void onResponse(Call<RequestData> call, Response<RequestData> response) {
                if (response.body().isStatus() == true) {
                    Toast.makeText(RegisterActivity.this, "Berhasil Registrasi", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                        Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
            }
            @Override
            public void onFailure(Call<RequestData> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}