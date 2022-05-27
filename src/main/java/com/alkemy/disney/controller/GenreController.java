package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    private GenreServiceImpl genreService;

    @PostMapping("/genres")
    public GenreDTO addGenre(@RequestBody GenreDTO genre) {
        return genreService.addGenre(genre);
    }
}
