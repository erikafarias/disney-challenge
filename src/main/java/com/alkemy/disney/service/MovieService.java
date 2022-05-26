package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<MovieListDTO> getAllMovies();
    public MovieDetailDTO getMovieById(Long id);
}
