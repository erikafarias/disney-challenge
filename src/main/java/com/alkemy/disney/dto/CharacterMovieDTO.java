package com.alkemy.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CharacterMovieDTO {
    private Long id;
    @NotNull
    private String image;
    @NotNull
    private String name;
    @NotNull @PositiveOrZero
    private Integer age;
    @NotNull @PositiveOrZero
    private Double weight;
    @NotNull
    private String history;
}
