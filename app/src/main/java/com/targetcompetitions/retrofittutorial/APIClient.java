package com.targetcompetitions.retrofittutorial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static final String BASE_URL = "https://api.github.com";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        if(retrofit == null){
            // if null then create and return and if not then return
            // the existing object
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }

        return retrofit;
    }
}
