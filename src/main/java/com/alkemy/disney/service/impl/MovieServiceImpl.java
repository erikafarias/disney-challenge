package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterMovieDTO;
import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieListDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.ApiRequestException;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;

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
            MovieDetailDTO movieDTO = movieMapper.movieEntityToDTO(movieEntity);
            return movieDTO;

    }

    public MovieDetailDTO saveMovie(MovieDetailDTO movie){
        MovieEntity movieEntity = movieMapper.movieDTOToEntity(movie);
        movieEntity.setCreationDate(LocalDate.now());
        MovieEntity savedMovie = movieRepository.save(movieEntity);
        MovieDetailDTO savedMovieDTO = movieMapper.movieEntityToDTO(savedMovie);
        return savedMovieDTO;
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<MovieEntity> movie = movieRepository.findById(id);
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDetailDTO updateMovie(Long id, MovieUpdateDTO movieDTO) {
            GenreEntity genre = modelMapper.map(movieDTO.getGenre(), GenreEntity.class);
            MovieEntity movie = modelMapper.map(movieDTO, MovieEntity.class);

            Optional<MovieEntity> movieEntity = movieRepository.findById(id);
            MovieEntity movieToUpdate = movieEntity.get();
            movieToUpdate.setTitle(movie.getTitle());
            movieToUpdate.setImage(movie.getImage());
            movieToUpdate.setScore(movie.getScore());
            movieToUpdate.setGenre(genre);

            MovieEntity updatedMovie = movieRepository.save(movieToUpdate);
            return movieMapper.movieEntityToDTO(updatedMovie);
    }
}
