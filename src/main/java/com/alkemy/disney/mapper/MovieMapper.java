package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterMovieDTO;
import com.alkemy.disney.dto.MovieDetailDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MovieMapper {

    ModelMapper modelMapper = new ModelMapper();

    public MovieDetailDTO movieEntityToDTO(MovieEntity movieEntity){
        Set<CharacterMovieDTO> characters = new HashSet<>();
        for (CharacterEntity c: movieEntity.getCharacters()) {
            CharacterMovieDTO characterDTO = modelMapper.map(c, CharacterMovieDTO.class);
            characters.add(characterDTO);
        }
        String genre = movieEntity.getGenre().getName();
        MovieDetailDTO movieDTO = modelMapper.map(movieEntity, MovieDetailDTO.class);
        movieDTO.setCharacters(characters);
        movieDTO.setGenre(genre);
        return movieDTO;
    }
}
