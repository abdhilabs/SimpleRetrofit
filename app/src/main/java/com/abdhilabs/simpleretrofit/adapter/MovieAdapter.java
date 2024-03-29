package com.abdhilabs.simpleretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdhilabs.simpleretrofit.R;
import com.abdhilabs.simpleretrofit.model.ItemResponseMovie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<ItemResponseMovie> itemResponseMovieList;
    private Context context;

    public MovieAdapter(List<ItemResponseMovie> itemResponseMovieList, Context context) {
        this.itemResponseMovieList = itemResponseMovieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int i) {
        holder.tvTitle.setText(itemResponseMovieList.get(i).getTitle());
        holder.tvReleased.setText(itemResponseMovieList.get(i).getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return itemResponseMovieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvReleased;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.text_title);
            tvReleased = itemView.findViewById(R.id.text_released);
        }
    }
}
