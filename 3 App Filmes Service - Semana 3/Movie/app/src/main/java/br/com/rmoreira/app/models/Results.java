package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robsonmoreira on 25/10/17.
 */

public class Results<T> {

    @SerializedName("results")
    private List<T> data;

    public List<T> getData() {
        return data;
    }

}
