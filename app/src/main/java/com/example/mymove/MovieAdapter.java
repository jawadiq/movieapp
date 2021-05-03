
package com.example.mymove;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymove.apis.Constants;
import com.example.mymove.layout.MovieDescription;
import com.example.mymove.models.JSONResponse;
import com.example.mymove.models.Movies;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> implements Filterable {
    private Context mContext;
    private List<Movies> moviesList;
    private ItemClickListener listener;



    public MovieAdapter(Context mContext, List<Movies> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_items,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.title.setText(moviesList.get(position).getTitle());
        holder.description.setText(moviesList.get(position).getDescription());
        Picasso.get().load(moviesList.get(position).getLogo()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Descriptions.class);
                intent.putExtra("movietitle",moviesList.get(position).getTitle());
                intent.putExtra("moviedescription",moviesList.get(position).getDescription());
                intent.putExtra("movieimg",moviesList.get(position).getLogo());
             mContext.startActivity(intent);
Toast.makeText(mContext,moviesList.get(position).getTitle(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title,description;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
            img = itemView.findViewById(R.id.item_image);
        }
    }
    public interface ItemClickListener{
        public void OnItemClick(Movies movies);
    }
}
