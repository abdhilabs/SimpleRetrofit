package com.abdhilabs.simpleretrofit.api;

import com.abdhilabs.simpleretrofit.model.MovieArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientService {
    @GET("movie?api_key=995351073e521ebe15db309b37cc0ca2&language=en-US")
    Call<MovieArray> getDataMovie();
}
