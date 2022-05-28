package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;

import java.util.List;


public interface MovieService {
     List<MovieListDTO> getAllMovies();
     MovieDetailDTO getMovieById(Long id);
     MovieDetailDTO saveMovie(MovieDetailDTO movie);
     void deleteMovie(Long id);
}
