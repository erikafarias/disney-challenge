package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieListDTO>> getMovies(){
        List<MovieListDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
}

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDetailDTO> getMovieById(@PathVariable Long id){
        MovieDetailDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok().body(movie);
    }
}
