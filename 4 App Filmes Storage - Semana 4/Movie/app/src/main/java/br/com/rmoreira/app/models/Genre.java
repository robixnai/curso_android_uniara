package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by robsonmoreira on 25/10/17.
 */

public class Genre implements Serializable {

    @SerializedName("id") private Integer id;
    @SerializedName("name") private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
