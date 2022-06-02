package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor
public class MovieUpdateDTO {
    private Long id;
    @NotNull
    private String image;
    @NotNull
    private String title;
    private LocalDate creationDate;
    @NotNull @Min(1) @Max(5)
    private int score;
    @NotNull
    private Long genreId;
}
