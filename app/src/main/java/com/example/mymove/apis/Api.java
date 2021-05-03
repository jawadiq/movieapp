package com.example.mymove.apis;

import com.example.mymove.models.JSONResponse;
import com.example.mymove.models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("movies")
    Call<JSONResponse> getModels();

}
