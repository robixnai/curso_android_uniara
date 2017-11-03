package br.com.rmoreira.app.models;

import java.io.Serializable;

/**
 * Created by robsonmoreira on 20/10/17.
 */

public class Movie implements Serializable {

    private int imageResources;
    private String title;
    private Double average;
    private int year;
    private String category;
    private String summary;

    public Movie(int imageResources, String title, Double average, int year, String category, String summary) {
        this.imageResources = imageResources;
        this.title = title;
        this.average = average;
        this.year = year;
        this.category = category;
        this.summary = summary;
    }

    public int getImageResources() {
        return imageResources;
    }

    public void setImageResources(int imageResources) {
        this.imageResources = imageResources;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
