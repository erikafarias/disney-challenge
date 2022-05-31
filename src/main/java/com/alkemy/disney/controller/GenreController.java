package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/genres")
    public GenreDTO addGenre(@Valid @RequestBody GenreDTO genre) {
        return genreService.addGenre(genre);
    }
}
