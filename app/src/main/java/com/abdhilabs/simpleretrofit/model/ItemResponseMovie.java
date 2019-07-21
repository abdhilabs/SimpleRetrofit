package com.abdhilabs.simpleretrofit.model;

import com.google.gson.annotations.SerializedName;

public class ItemResponseMovie {
    @SerializedName("poster_path")
    private String poster;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    public String getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
