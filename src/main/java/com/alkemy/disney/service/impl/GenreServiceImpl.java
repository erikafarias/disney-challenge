package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.specifications.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDTO addGenre(GenreDTO dto) {
        GenreEntity genreEntity = genreRepository.save(genreMapper.genreDTO2Entity(dto));
        return genreMapper.genreEntity2DTO(genreEntity);
    }
}
