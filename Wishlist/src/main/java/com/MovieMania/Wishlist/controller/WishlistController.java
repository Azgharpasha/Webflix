package com.MovieMania.Wishlist.controller;

import com.MovieMania.Wishlist.exception.MovieAlreadyExistsException;
import com.MovieMania.Wishlist.model.Movies;
import com.MovieMania.Wishlist.service.WishListService;
import com.MovieMania.Wishlist.service.WishListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/wishListService")
@CrossOrigin("*")
public class WishlistController {

    @Autowired
    WishListService wishlistService;

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> handleMovieAlreadyExistsException(MovieAlreadyExistsException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    @PostMapping("/movie/save")
    public ResponseEntity<?> saveMovie(@RequestParam String emailId, @RequestBody Movies movies){

        try {

            System.out.println(emailId);
            System.out.println(movies.getMovieRank());
            System.out.println(movies.getTitle());
            System.out.println(movies.getDescription());
            System.out.println(movies.getImage());
            System.out.println(movies.getRating());
            System.out.println(movies.getYear());
            System.out.println(movies);

            return new ResponseEntity<>(wishlistService.saveMovies(emailId, movies), HttpStatus.CREATED);
         }
        catch (MovieAlreadyExistsException ex){
            throw ex;
        }
        catch (RuntimeException ex){
            throw new RuntimeException("An Error occured" + ex.getMessage(), ex);
        }
    }

    @GetMapping("/movies/{email}")
    public ResponseEntity<?> getMoviesByUserId(@PathVariable String email){
        return new ResponseEntity<>(wishlistService.getMoviesByUserId(email), HttpStatus.OK);

    }

    @DeleteMapping("/delete/movie")
    public ResponseEntity<?> deleteAllMoviesByUserId(@RequestParam String emailId){
        wishlistService.deleteAllMoviesByUserId(emailId);;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/movie/{id}/{email}")
    public ResponseEntity<?> deleteMovieByMovieId(@PathVariable String id,@PathVariable String email){
        wishlistService.deleteMoviesByMovieId(id,email);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }







}
