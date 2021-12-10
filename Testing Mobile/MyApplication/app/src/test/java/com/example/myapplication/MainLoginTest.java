package com.example.myapplication;

import static org.junit.Assert.*;

import android.util.Log;


import com.example.myapplication.API.ApiClient;
import com.example.myapplication.API.LoginInterface;
import com.example.myapplication.Model.Login;
import com.example.myapplication.Model.LoginResponse;
import com.example.myapplication.Model.RequestLogin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@RunWith(MockitoJUnitRunner.class)

public class MainLoginTest {
    private static final String FAKE_STRING = "Berhasil";
    private String Email = "pujir3306@gmail.com";
    private String Password = "123";
    private RequestLogin requestLogin;
    private String message;
    private LoginInterface loginInterface;


    @Before
    public void beforeTest(){
        MockitoAnnotations.initMocks(this);
        loginInterface = ApiClient.getClient().create(LoginInterface.class);

    }

    @Test
    public void loginUserTest(){
        loginInterface.loginResponse(Email, Password).enqueue(new Callback<RequestLogin>() {
            @Override
            public void onResponse(Call<RequestLogin> call, Response<RequestLogin> response) {
                requestLogin = response.body();
                message = requestLogin.getMessage().toString();
                System.out.println(message);
            }

            @Override
            public void onFailure(Call<RequestLogin> call, Throwable t) {
                Log.e("error", t.getMessage());
            }
        });

        Assert.assertNotNull(requestLogin);
        System.out.println(requestLogin.getMessage());
        assert message.equals(FAKE_STRING);



    }
}