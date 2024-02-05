package com.MovieMania.MoviesList.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import java.util.List;

public class Movies {

    private String id;

    private int rank;

    private String title;

    private String description;

    private String image;

    private List<String> genre;

    private double rating;

    private long year;

    public Movies() {
    }

    public Movies(String id, int rank, String title, String description, String image, List<String> genre, double rating, int year) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.description = description;
        this.image = image;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
