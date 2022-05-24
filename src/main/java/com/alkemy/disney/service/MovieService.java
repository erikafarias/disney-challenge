package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<MovieDetailDTO> getAllMovies();
}
