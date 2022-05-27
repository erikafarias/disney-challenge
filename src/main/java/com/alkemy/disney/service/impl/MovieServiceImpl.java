package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<MovieListDTO> getAllMovies(){
        List<MovieEntity> moviesEntities = movieRepository.findAll();
        List<MovieListDTO> moviesDTO = new ArrayList<>();
        for (MovieEntity m:moviesEntities) {
            MovieListDTO mDTO = modelMapper.map(m, MovieListDTO.class);
            moviesDTO.add(mDTO);
        }
        return moviesDTO;
    }

    public MovieDetailDTO getMovieById(Long id){
        MovieEntity movieEntity = movieRepository.getMovieById(id);
        MovieDetailDTO movieDTO = modelMapper.map(movieEntity, MovieDetailDTO.class);
        return movieDTO;
    }

    public MovieDetailDTO saveMovie(MovieDetailDTO movie){
        MovieEntity movieEntity = modelMapper.map(movie, MovieEntity.class);
        movieEntity.setCreationDate(LocalDate.now());
        MovieEntity savedMovie = movieRepository.save(movieEntity);
        MovieDetailDTO savedMovieDTO = modelMapper.map(savedMovie, MovieDetailDTO.class);
        return savedMovieDTO;
    }
}
