package com.abdhilabs.simpleretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdhilabs.simpleretrofit.R;
import com.abdhilabs.simpleretrofit.model.ItemResponseMovie;
import com.bumptech.glide.Glide;

import java.util.List;

public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieAdapter.SearchViewHolder> {
    private Context context;
    private List<ItemResponseMovie> list;

    public SearchMovieAdapter(Context context, List<ItemResponseMovie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_search, viewGroup, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int i) {
        String pathGambar = list.get(i).getPoster();
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w500" + pathGambar)
                .into(holder.imgPoster);
        holder.tvTitle.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle;

        SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.searchImage);
            tvTitle = itemView.findViewById(R.id.searchTitle);
        }
    }
}
