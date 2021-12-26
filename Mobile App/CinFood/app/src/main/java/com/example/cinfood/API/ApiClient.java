package com.example.cinfood.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    // iki cuma kari ngubah ip, ojok di tambai head ... eror mau gess
<<<<<<< HEAD
 private static final String BASE_URL = "http://192.168.100.22/cinmobile/";
=======
 private static final String BASE_URL = "http://192.168.100.2/cinmobile/";
>>>>>>> 533de8520fdf36015e30d184bf0fda40c0d43b7d
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
