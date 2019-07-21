package com.abdhilabs.simpleretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieArray {
    @SerializedName("results")
    private List<Movie> list;

    public List<Movie> getListMovie() {
        return list;
    }
}
