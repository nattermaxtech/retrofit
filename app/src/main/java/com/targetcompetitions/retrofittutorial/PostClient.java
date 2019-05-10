package com.targetcompetitions.retrofittutorial;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostClient {

    @POST("/posts")
    Call<Post> add(@Body Post post);
}
