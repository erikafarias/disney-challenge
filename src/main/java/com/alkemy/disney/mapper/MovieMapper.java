package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterMovieDTO;
import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.dto.MovieUpdateDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class MovieMapper {

    public ModelMapper modelMapper = new ModelMapper();





    public MovieDetailDTO movieEntityToDTO(MovieEntity movieEntity){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Set<CharacterMovieDTO> characters = new HashSet<>();
        for (CharacterEntity c: movieEntity.getCharacters()) {
            CharacterMovieDTO characterDTO = modelMapper.map(c, CharacterMovieDTO.class);
            characters.add(characterDTO);
        }
        MovieDetailDTO movieDTO = modelMapper.map(movieEntity, MovieDetailDTO.class);
        movieDTO.setCharacters(characters);
        return movieDTO;
    }

    public MovieEntity movieDTOToEntity(MovieDetailDTO movieDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Set<CharacterEntity> characters = new HashSet<>();
        for (CharacterMovieDTO c: movieDTO.getCharacters()) {
            CharacterEntity characterEntity = modelMapper.map(c, CharacterEntity.class);
            characters.add(characterEntity);
        }
        MovieEntity movieEntity = modelMapper.map(movieDTO, MovieEntity.class);
        movieEntity.setCreationDate(LocalDate.now());
        movieEntity.setCharacters(characters);
        return movieEntity;
    }

    public MovieEntity updateMovieMapper(MovieUpdateDTO movieDTO, MovieEntity movieToUpdate){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        MovieEntity movie = modelMapper.map(movieDTO, MovieEntity.class);

        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setImage(movie.getImage());
        movieToUpdate.setScore(movie.getScore());
        movieToUpdate.setGenreId(movie.getGenreId());

        return movieToUpdate;
    }
}
