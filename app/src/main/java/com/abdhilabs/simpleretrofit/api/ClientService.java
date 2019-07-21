package com.abdhilabs.simpleretrofit.api;

import com.abdhilabs.simpleretrofit.model.ModelResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ClientService {
    @GET("movie?api_key=995351073e521ebe15db309b37cc0ca2&language=en-US")
    Call<ModelResponseMovie> getDataMovie();

    @GET("movie?api_key=995351073e521ebe15db309b37cc0ca2&page=1&include_adult=false")
    Call<ModelResponseMovie> getSearchMovie(@Query("query") String query);
}
