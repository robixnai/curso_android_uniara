package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by robsonmoreira on 25/10/17.
 */

public class ParseObject<T> {

    @SerializedName("results") private List<T> movies;
    @SerializedName("genres") private List<T> genres;

    public List<T> getMovies() {
        return movies;
    }

    public List<T> getGenres() {
        return genres;
    }

}
