package com.abdhilabs.simpleretrofit.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
