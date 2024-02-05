package com.MovieMania.Wishlist.exception;

public class MovieAlreadyExistsException extends RuntimeException{

    public MovieAlreadyExistsException(String message){
        super(message);
    }
}
