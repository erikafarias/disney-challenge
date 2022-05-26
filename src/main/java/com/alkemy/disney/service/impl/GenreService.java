package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.repository.specifications.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreEntity addGenre(GenreEntity genre) {
        genreRepository.save(genre);
        return genre;
    }


}
