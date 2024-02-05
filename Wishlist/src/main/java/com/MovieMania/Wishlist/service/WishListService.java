package com.MovieMania.Wishlist.service;

import com.MovieMania.Wishlist.model.Movies;


import java.util.List;

public interface WishListService {

    public Movies saveMovies(String emailId, Movies movies);

    public List<Movies> getMoviesByUserId(String emailId);

    public void deleteAllMoviesByUserId(String emailId);

    public void deleteMoviesByMovieId(String id,String email);
}
