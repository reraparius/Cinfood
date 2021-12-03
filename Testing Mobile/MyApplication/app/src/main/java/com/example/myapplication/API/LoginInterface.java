package com.example.myapplication.API;

import com.example.myapplication.Model.LoginResponse;
import com.example.myapplication.Model.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
   // String LOGINURL = "https://192.168.0.101/cinmobile/";
    @FormUrlEncoded
    @POST("Login.php")
    Call<RequestLogin> loginResponse(

            @Field("email_user") String Email,
            @Field("password") String Password
    );
}
