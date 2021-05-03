package com.example.mymove.models;

import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    @SerializedName("movie_app_movies")
    private Movies[] movie_app_movies;

    public JSONResponse(Movies[] movie_app_movies) {
        this.movie_app_movies = movie_app_movies;
    }

    public Movies[] getMovie_app_movies() {
        return movie_app_movies;
    }

    public void setMovie_app_movies(Movies[] movie_app_movies) {
        this.movie_app_movies = movie_app_movies;
    }
}
