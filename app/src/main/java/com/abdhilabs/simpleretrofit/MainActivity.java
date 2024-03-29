package com.abdhilabs.simpleretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.abdhilabs.simpleretrofit.adapter.MovieAdapter;
import com.abdhilabs.simpleretrofit.api.ClientService;
import com.abdhilabs.simpleretrofit.model.ItemResponseMovie;
import com.abdhilabs.simpleretrofit.model.ModelResponseMovie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<ItemResponseMovie> itemResponseMovieList = new ArrayList<>();
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
        Call<ModelResponseMovie> request = service.getDataMovie();

        //Mengirimkan request instansi
        request.enqueue(new Callback<ModelResponseMovie>() {
            @Override
            public void onResponse(Call<ModelResponseMovie> call, Response<ModelResponseMovie> response) {
                itemResponseMovieList = response.body().getListMovie();
                MovieAdapter adapter = new MovieAdapter(itemResponseMovieList, MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ModelResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Hiyah we gak iso :v", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void pindah(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
}
