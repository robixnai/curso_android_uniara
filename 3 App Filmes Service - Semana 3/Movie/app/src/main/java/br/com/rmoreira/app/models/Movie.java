package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robsonmoreira on 20/10/17.
 */

public class Movie implements Serializable {

    private static final String URI_IMAGE = "https://image.tmdb.org/t/p/w500";

    @SerializedName("id") private Integer id;
    @SerializedName("title") private String title;
    @SerializedName("vote_average") private Double average;
    @SerializedName("overview") private String summary;
    @SerializedName("release_date") private String year;
    @SerializedName("backdrop_path") private String imagePath;
    @SerializedName("genre_ids") private List<Integer> category;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAverage() {
        return average;
    }

    public String getSummary() {
        return summary;
    }

    public String getYear() {
        return year.substring(0, 4);
    }

    public String getImagePath() {
        return (imagePath != null) ? URI_IMAGE.concat(imagePath) : "";
    }

    public String getCategory() {
        String categoryString = "";
        if (category.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < category.size() - 1; i++) {
                if (!category.get(i).toString().matches(" *")) {
                    sb.append(category.get(i));
                    sb.append(", ");
                }
            }
            sb.append(category.get(category.size() - 1).toString().trim());
            categoryString = sb.toString();
        }
        return categoryString;
    }

}
