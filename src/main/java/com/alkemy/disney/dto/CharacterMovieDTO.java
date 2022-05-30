package com.alkemy.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CharacterMovieDTO {
    private Long id;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
}
