package com.alkemy.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class MovieListDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
}
