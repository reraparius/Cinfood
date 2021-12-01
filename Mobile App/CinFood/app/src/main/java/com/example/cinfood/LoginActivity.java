package com.example.cinfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinfood.API.ApiClient;
import com.example.cinfood.API.ApiInterface;
import com.example.cinfood.Model.RequestLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText Username1, Password1;
    Button btnLogin1;
    String Email,Password;
    ApiInterface apiInterface;

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
    private void loginUser(String email, String password){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<RequestLogin> loginCall = apiInterface.loginResponse(email, password);
        loginCall.enqueue(new Callback<RequestLogin>() {
            @Override
            public void onResponse(Call<RequestLogin> call, Response<RequestLogin> response) {
                if(response.body() != null){
                    if(response.body().isStatus()==true){
                        Intent intent = new Intent(LoginActivity.this, navbar.class);
                        startActivity(intent);
                        finish();
                         }
                            else{   Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();


                    }
                    }else {
                        Toast.makeText(LoginActivity.this, "Username dan Password harus di Isi", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<RequestLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Maaf anda tidak dapat login", Toast.LENGTH_SHORT).show();

            }
        });
}
}