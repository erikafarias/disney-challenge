package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class MovieDetailDTO {
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int score;
    private Long genreId;
    private Set<CharacterEntity> characters = new HashSet<>();
}