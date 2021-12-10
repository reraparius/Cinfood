package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.API.ApiClient;
import com.example.myapplication.API.LoginInterface;
import com.example.myapplication.Model.RequestLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    EditText Username1, Password1;
    Button btnLogin1;
    String Email,Password;
  //  private PreferenceHelper preferenceHelper;
    LoginInterface loginInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    preferenceHelper = new PreferenceHelper(this);

        //  getSupportActionBar().hide();

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
        loginInterface = ApiClient.getClient().create(LoginInterface.class);
    Call<RequestLogin> loginCall = loginInterface.loginResponse(email, password);
    loginCall.enqueue(new Callback<RequestLogin>() {
        @Override
        public void onResponse(Call<RequestLogin> call, Response<RequestLogin> response) {
          //  if(response.body() != null){
                if(response.body().isStatus()==true){
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
              //  }
            }else {
                Toast.makeText(MainActivity.this, "Tidak dapat login", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<RequestLogin> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Tidak dapat login", Toast.LENGTH_SHORT).show();

        }
    });

        }



    }
