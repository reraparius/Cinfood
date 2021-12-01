package com.example.cinfood.API;

import com.example.cinfood.Model.RequestLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    // String LOGINURL = "https://192.168.0.101/cinmobile/";
    @FormUrlEncoded
    @POST("Login.php")
    Call<RequestLogin> loginResponse(

            @Field("email_user") String Email,
            @Field("password") String Password
    );
}
