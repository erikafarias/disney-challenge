package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class MovieDetailDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int score;
    private GenreEntity genre;
    // TODO: cambiar a DTO cuando estén hechos
    private Set<CharacterEntity> characters = new HashSet<>();

    public MovieDetailDTO(String image, String title, int score, GenreEntity genre, Set<CharacterEntity> characters) {
        this.image = image;
        this.title = title;
        this.score = score;
        this.genre = genre;
        this.characters = characters;
    }
}