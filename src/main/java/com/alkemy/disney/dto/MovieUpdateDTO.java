package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor
public class MovieUpdateDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int score;
    private GenreDTO genre;
}
