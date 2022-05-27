package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public GenreEntity genreDTO2Entity(GenreDTO dto){
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(dto.getId());
        genreEntity.setName(dto.getName());
        return genreEntity;
    }

    public GenreDTO genreEntity2DTO(GenreEntity entity){
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(entity.getId());
        genreDTO.setName(entity.getName());
        return genreDTO;
    }

}
