package com.targetcompetitions.retrofittutorial;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostClient {

    @GET("/posts")
    Call<List<Post>> get();
}
