package com.example.cinfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cinfood.API.APIRequestData;
import com.example.cinfood.API.RetroServer;
import com.example.cinfood.Model.LoginData;
import com.example.cinfood.Model.loginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText Username, Password;
    Button btnLogin1;
    APIRequestData apiRequestData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        btnLogin1 = findViewById(R.id.btnLogin1);


        btnLogin1.setOnClickListener(this);

}
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin1:
                String user_name = Username.getText().toString();
                String password = Password.getText().toString();
//                Intent intent =new Intent(this, BerandaFragment.class);
//                startActivity(intent);
                Login(user_name, password);
                finish();
                break;

        }
}
private void Login(String user_name, String password){
        apiRequestData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<loginResponse> logincall = apiRequestData.LoginResponse(user_name, password);
        logincall.enqueue(new Callback<loginResponse>() {
            @Override
            public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                if(response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    //untuk menyimpan sesi
                    LoginData logindata =response.body().getLoginData();

                    Toast.makeText(LoginActivity.this, "BISADA", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

                }else {
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<loginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

}
}