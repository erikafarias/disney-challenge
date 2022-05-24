package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<MovieDetailDTO> getAllMovies(){
        List<MovieEntity> moviesEntities = movieRepository.findAll();
        List<MovieDetailDTO> moviesDTO = new ArrayList<>();
        for (MovieEntity m:moviesEntities) {
            MovieDetailDTO mDTO = modelMapper.map(m, MovieDetailDTO.class);
            moviesDTO.add(mDTO);
        }
        return moviesDTO;
    }
}
