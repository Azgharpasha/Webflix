package com.MovieMania.Wishlist.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="MoviesTable")
public class Movies {


    @Id
    private String id;

    private int movieRank;

    private String title;

    private String description;

    private String image;

    //private List<String> genre;

    private double rating;

    private long year;

    public Movies() {
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private WishList user;


    public Movies(String id, int movieRank, String title, String description, String image, double rating, int year,WishList user) {
        this.id = id;
        this.movieRank = movieRank;
        this.title = title;
        this.description = description;
        this.image = image;
        //this.genre = genre;
        this.rating = rating;
        this.year = year;
        this.user=user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMovieRank() {
        return movieRank;
    }

    public void setMovieRank(int movieRank) {
        this.movieRank = movieRank;
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

//    public List<String> getGenre() {
//        return genre;
//    }
//
//    public void setGenre(List<String> genre) {
//        this.genre = genre;
//    }

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

    public WishList getUser() {
        return user;
    }

    public void setUser(WishList user) {
        this.user = user;
    }
}
