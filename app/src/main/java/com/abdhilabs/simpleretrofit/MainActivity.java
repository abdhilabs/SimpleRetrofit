package com.abdhilabs.simpleretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.abdhilabs.simpleretrofit.adapter.MovieAdapter;
import com.abdhilabs.simpleretrofit.api.ClientService;
import com.abdhilabs.simpleretrofit.model.Movie;
import com.abdhilabs.simpleretrofit.model.MovieArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovies);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        //Membuat Objek Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/discover/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Mencetak pelayanan atau service
        ClientService service = retrofit.create(ClientService.class);

        //Membuat objek request
        Call<MovieArray> request = service.getDataMovie();

        //Mengirimkan request instansi
        request.enqueue(new Callback<MovieArray>() {
            @Override
            public void onResponse(Call<MovieArray> call, Response<MovieArray> response) {
                movieList = response.body().getListMovie();
                MovieAdapter adapter = new MovieAdapter(movieList, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieArray> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Hiyah we gak iso :v", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
