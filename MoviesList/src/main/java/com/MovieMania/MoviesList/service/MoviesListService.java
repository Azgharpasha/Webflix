package com.MovieMania.MoviesList.service;

import com.MovieMania.MoviesList.model.Movies;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MoviesListService {

    private final String access_key = "d9f4eb981cmshab85771fe66afdfp1ddecfjsnc75d6e38b059";

    private final String access_url = "https://imdb-top-100-movies.p.rapidapi.com/";

    public RestTemplate restTemplate;

    public MoviesListService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Movies getMovieById(String id) {
        String url = access_url + "/" + id;
        ResponseEntity<Movies> response = restTemplate.exchange(url, HttpMethod.GET, setHeaders(), Movies.class);
        return response.getBody();
    }

    public List<Movies> getMovies() {
        ResponseEntity<List> response = restTemplate.exchange(access_url, HttpMethod.GET, setHeaders(), List.class);
        return response.getBody();
    }

    public HttpEntity<?> setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", access_key);
        return new HttpEntity<>(headers);
    }
}
