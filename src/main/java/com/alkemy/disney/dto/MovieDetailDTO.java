package com.alkemy.disney.dto;

import com.alkemy.disney.entity.GenreEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class MovieDetailDTO {
    private Long id;
    @NotNull
    private String image;
    @NotNull
    private String title;
    private LocalDate creationDate;
    @NotNull @Min(1) @Max(5)
    private int score;
    @NotNull
    private GenreDTO genre;
    @NotNull
    private Set<CharacterMovieDTO> characters = new HashSet<>();

    public MovieDetailDTO(String image, String title, int score, GenreDTO genre, Set<CharacterMovieDTO> characters) {
        this.image = image;
        this.title = title;
        this.score = score;
        this.genre = genre;
        this.characters = characters;
    }
}