package com.alkemy.disney.controller;

import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.service.impl.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/genres")
    public GenreEntity addGenre(@RequestBody GenreEntity genre) {
        return genreService.addGenre(genre);
    }
}
