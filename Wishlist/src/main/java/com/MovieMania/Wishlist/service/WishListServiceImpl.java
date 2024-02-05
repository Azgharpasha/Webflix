package com.MovieMania.Wishlist.service;

import com.MovieMania.Wishlist.model.Movies;
import com.MovieMania.Wishlist.model.WishList;
import com.MovieMania.Wishlist.repo.MovieRepository;
import com.MovieMania.Wishlist.repo.WishListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService{



    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    MovieRepository movieRepository;


    @Override
    public Movies saveMovies(String emailId, Movies movies) {
        WishList wishList = wishListRepository.findByEmailId(emailId);

        movies.setUser(wishList);

        return  movieRepository.save(movies);
    }

    @Override
    public List<Movies> getMoviesByUserId(String emailId) {
        WishList wishList = wishListRepository.findByEmailId(emailId);

        List<Movies> movies =  movieRepository.findByUserId(wishList.getUserId()).get();
        return movies;
    }

    @Override
    public void deleteAllMoviesByUserId(String emailId) {
        WishList wishList = wishListRepository.findByEmailId(emailId);

        movieRepository.deleteAllByUserId(wishList.getUserId());

    }

    @Override
    @Transactional
    public void deleteMoviesByMovieId(String id,String email) {
        WishList user=wishListRepository.findByEmailId(email);

        movieRepository.deleteByMovieIdAndUserId(id,user.getUserId());

    }
}
