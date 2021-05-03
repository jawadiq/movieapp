package com.example.mymove.apis;

import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder  retrofitBuilder = new Retrofit.Builder().baseUrl(Constants.URl).addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit;
    private static Api api = retrofit.create(Api.class);


    public Api getApi(){
        return  api;
    }
}
