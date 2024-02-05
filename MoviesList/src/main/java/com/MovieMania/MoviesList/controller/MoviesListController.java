package com.MovieMania.MoviesList.controller;

import com.MovieMania.MoviesList.service.MoviesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin("*")
public class MoviesListController {

    @Autowired
    private MoviesListService moviesListService;

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable String id) {
        return new ResponseEntity<>(moviesListService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getMovies() {
        return new ResponseEntity<>(moviesListService.getMovies(), HttpStatus.OK);
    }

}
