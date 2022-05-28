package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/movies/create")
    public ResponseEntity<MovieDetailDTO> saveMovie(@RequestBody MovieDetailDTO movie){
        MovieDetailDTO movieSaved = movieService.saveMovie(movie);
        return ResponseEntity.ok().body(movieSaved);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok().body("Movie deleted successfully");
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieDetailDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDetailDTO movie){
        MovieDetailDTO movieUpdated = movieService.updateMovie(id, movie);
        return ResponseEntity.ok().body(movieUpdated);
    }
}
