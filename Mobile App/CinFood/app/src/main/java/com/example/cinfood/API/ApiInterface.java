package com.example.cinfood.API;

import com.example.cinfood.Model.RequestData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("Login.php")
    Call<RequestData> loginResponse(

            @Field("email_user") String Email,
            @Field("password") String Password
    );
    @FormUrlEncoded
    @POST("Registrasi.php")
    Call<RequestData> RegistResponse(

            @Field("namaLengkap") String Nama,
            @Field("email_user") String Email,
            @Field("password") String Password,
            @Field("alamat") String Alamat
    );

}
