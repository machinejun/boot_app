package com.example.movie_one.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    private int id;
    private String title;
    private double rating;
    private int runtime;
    private String summary;
    private String synopsis;
    private int year;
    @SerializedName("background_image")
    @Expose
    private String backGroundImg;
    @SerializedName("medium_cover_image")
    @Expose
    private String MediumCoverImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBackGroundImg() {
        return backGroundImg;
    }

    public void setBackGroundImg(String backGroundImg) {
        this.backGroundImg = backGroundImg;
    }

    public String getMediumCoverImg() {
        return MediumCoverImg;
    }

    public void setMediumCoverImg(String mediumCoverImg) {
        MediumCoverImg = mediumCoverImg;
    }
}
