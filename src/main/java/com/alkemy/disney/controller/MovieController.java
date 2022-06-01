package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieListDTO>> getMovies(){
        List<MovieListDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
}

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> getMovieById(@PathVariable Long id){
        MovieDetailDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping
    public ResponseEntity<MovieDetailDTO> saveMovie(@Valid @RequestBody MovieDetailDTO movie){
        MovieDetailDTO movieSaved = movieService.saveMovie(movie);
        return ResponseEntity.ok().body(movieSaved);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> updateMovie(@PathVariable Long id,@Valid @RequestBody MovieUpdateDTO movie){
        MovieDetailDTO movieUpdated = movieService.updateMovie(id, movie);
        return ResponseEntity.ok().body(movieUpdated);
    }
}
