package com.example.cinfood.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    // iki cuma kari ngubah ip, ojok di tambai head ... eror mau gess
 private static final String BASE_URL = "http://192.168.100.22/cinmobile/";
//private static final String BASE_URL = "http://192.168.0.101/cinmobile/";
//private static final String BASE_URL = "http://192.168.0.101/cinmobile/";

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
