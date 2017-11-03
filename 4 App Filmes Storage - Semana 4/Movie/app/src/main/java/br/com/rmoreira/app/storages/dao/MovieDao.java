package br.com.rmoreira.app.storages.dao;

import br.com.rmoreira.app.models.Movie;
import br.com.rmoreira.app.utils.MovieUtils;

/**
 * Created by robsonmoreira on 01/11/17.
 */

public class MovieDao {

    private Integer id;
    private String title;
    private Double average;
    private String summary;
    private Integer year;
    private String imagePath;
    private String genres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Movie movieMap() {
        return new Movie(
                this.id,
                this.title,
                this.average,
                this.summary,
                this.year.toString(),
                this.imagePath,
                MovieUtils.getGenres(this.genres)
        );
    }

}
