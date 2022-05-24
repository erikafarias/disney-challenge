package com.alkemy.disney.controller;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDetailDTO>> getMovies(){
        List<MovieDetailDTO> movies = movieService.getAllMovies();
}
}
