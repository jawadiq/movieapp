package com.example.mymove;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymove.apis.Constants;
import com.example.mymove.models.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Descriptions extends AppCompatActivity {
    private String movieId;
    private Intent intent;
    private List<Movies> moviesList;
    TextView title,description;
    int position;
    Bundle b;
    ImageView detailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptions);
        title = findViewById(R.id.dcTitle);
        detailsView = findViewById(R.id.imageView);
       description=findViewById(R.id.description);
 String titles = getIntent().getStringExtra("movietitle");
 String imager = getIntent().getStringExtra("movieimg");
 String details = getIntent().getStringExtra("moviedescription");
 title.setText(titles);
 description.setText(details);
        Picasso.get().load(imager).into(detailsView);
    }

    public void home(View view) {
        Intent x =  new Intent(this, MainActivity.class);
        startActivity(x);
    }
}