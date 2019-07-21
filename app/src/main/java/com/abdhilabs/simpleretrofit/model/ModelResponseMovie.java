package com.abdhilabs.simpleretrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelResponseMovie {
    @SerializedName("results")
    private List<ItemResponseMovie> list;

    public List<ItemResponseMovie> getListMovie() {
        return list;
    }
}
