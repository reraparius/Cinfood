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
import com.example.cinfood.Model.UserModel;
import com.example.cinfood.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText Username1, Password1;
    Button btnLogin1;
    String Email,Password;
    ApiInterface apiInterface;

     // credential data
    String id_user, nama, tgl_lahir, no_hp, alamat, email_user, password_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Username1 = findViewById(R.id.Username);
        Password1 = findViewById(R.id.Password);
        btnLogin1 = findViewById(R.id.btnLogin1);


        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnLogin1:
                        Email = Username1.getText().toString();
                        Password = Password1.getText().toString();
                        loginUser(Email, Password);
                        break;
                }

            }
        });

}

  //method untuk mencocokkan email dan password user.
     private void loginUser(String email, String password) {
         apiInterface = ApiClient.getClient().create(ApiInterface.class);
         Call<RequestData> loginCall = apiInterface.loginResponse(email, password);
         loginCall.enqueue(new Callback<RequestData>() {
             @Override
             public void onResponse(Call<RequestData> call, Response<RequestData> response) {
                  if(response.body().isStatus()==true){
                      List<UserModel> userModels = response.body().getData();
                    for (UserModel userModel : userModels) {
                        id_user = userModel.getId_user();
                        nama = userModel.getNamaLengkap();
                        tgl_lahir = userModel.getTgl_lahir();
                        no_hp = userModel.getNo_hp();
                        alamat = userModel.getAlamat();
                        email_user = userModel.getEmail_user();
                        password_data = userModel.getPassword();
                    }
                    //set data edit profile
                    Intent intent = new Intent(LoginActivity.this, navbar.class);
                    startActivity(intent);
                    finish();

                  }else {
                    Toast.makeText(LoginActivity.this, "Tidak dapat login", Toast.LENGTH_SHORT).show();
                }
             }

             @Override
             public void onFailure(Call<RequestData> call, Throwable t) {
                       Toast.makeText(LoginActivity.this, "Tidak dapat login", Toast.LENGTH_SHORT).show();

             }
         });

    }

}