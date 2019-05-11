package com.targetcompetitions.retrofittutorial;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PostClient {

    @Headers({
            "User-Agent: Mozilla/5.0",
            "Accept: application/json",
    })
    @GET("/posts")
    Call<List<Post>> get();
}
