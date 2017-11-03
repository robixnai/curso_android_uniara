package br.com.rmoreira.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import br.com.rmoreira.app.storages.dao.MovieDao;
import br.com.rmoreira.app.utils.MovieUtils;

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
    @SerializedName("genre_ids") private List<Integer> genres;

    public Movie(Integer id, String title, Double average, String summary, String year, String imagePath, List<Integer> genres) {
        this.id = id;
        this.title = title;
        this.average = average;
        this.summary = summary;
        this.year = year;
        this.imagePath = imagePath;
        this.genres = genres;
    }

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

    public List<Integer> getGenres() {
        return genres;
    }

    public MovieDao movieMap() {
        MovieDao movieDao = new MovieDao();
        movieDao.setId(this.id);
        movieDao.setTitle(this.title);
        movieDao.setAverage(this.average);
        movieDao.setSummary(this.summary);
        movieDao.setYear(Integer.valueOf(this.getYear()));
        movieDao.setImagePath(this.imagePath);
        movieDao.setGenres(MovieUtils.getCategory(this.getGenres()));
        return movieDao;
    }

}
