package com.abdhilabs.simpleretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.abdhilabs.simpleretrofit.adapter.SearchMovieAdapter;
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

public class SearchActivity extends AppCompatActivity {
    private List<ItemResponseMovie> listSearch = new ArrayList<>();
    private RecyclerView recyclerView;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.rvSearchMovie);
        etSearch = findViewById(R.id.etSearch);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
    }

    public void search(View view) {
        String search = etSearch.getText().toString().toUpperCase();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sek sabar...");
        progressDialog.show();

        //Buat Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Buat Service
        ClientService service = retrofit.create(ClientService.class);

        //Pilih jenis Service
        Call<ModelResponseMovie> request = service.getSearchMovie(search);

        //Kirim Request
        request.enqueue(new Callback<ModelResponseMovie>() {
            @Override
            public void onResponse(Call<ModelResponseMovie> call, Response<ModelResponseMovie> response) {
                progressDialog.dismiss();
                if (response.body() != null) {
                    listSearch = response.body().getListMovie();
                }
                SearchMovieAdapter adapter = new SearchMovieAdapter(SearchActivity.this, listSearch);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ModelResponseMovie> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SearchActivity.this, "Hiyah we gak iso :v", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
