package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by robsonmoreira on 26/10/17.
 */

public class Trailer implements Serializable {

    @SerializedName("name") private String name;
    @SerializedName("key") private String key;

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

}
