package com.example.mymove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymove.apis.Api;
import com.example.mymove.models.JSONResponse;
import com.example.mymove.models.Main;
import com.example.mymove.models.Movies;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String URL = "https://playground.devskills.co/api/rest/movie-app/ ";
    TextView testData;
    Button button;
    List<Movies> moviesList;
//   https://run.mocky.io/v3/dba07775-4a52-4ce3-a616-3a4a2fbb0c9b
RecyclerView recyclerView;
SearchView searchView;
    Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
    Api api = retrofit.create(Api.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.ultimateRecyclerView);
        moviesList = new ArrayList<>();
        searchView = findViewById(R.id.search);




    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Call<JSONResponse> call = api.getModels();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                moviesList = new ArrayList<>(Arrays.asList(jsonResponse.getMovie_app_movies()));
//       String abc =  moviesList.get(2).getTitle();  test

                populateMovieData(moviesList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });
    }

    private void populateMovieData(List<Movies> moviesList) {
        MovieAdapter adapter = new MovieAdapter(this,moviesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


}