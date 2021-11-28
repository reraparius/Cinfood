package com.example.cinfood.API;

import com.android.volley.Request;
import com.example.cinfood.Model.User;
import com.example.cinfood.Model.UserResponse;
import com.example.cinfood.Model.loginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    //untuk login
    @FormUrlEncoded
    @POST("Login.php")
    Call<loginResponse> LoginResponse(
            @Field("email_user") String user_name,
            @Field("password") String password);

    @GET("User_Registration.php")
    Call<UserResponse> getUser();

    @POST("User_Registration.php")
    Call<Request> sendUser(@Body User user);


}
