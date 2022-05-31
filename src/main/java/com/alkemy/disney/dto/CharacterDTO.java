package com.alkemy.disney.dto;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {
    private Long id;

    @NotNull
    private String name;

    @NotNull @PositiveOrZero
    private Integer age;
    @NotNull @PositiveOrZero
    private Double weight;
    @NotNull
    private String history;
    private List<MovieEntity> movies;

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", history='" + history + '\'' +
                ", movies=" + movies +
                '}';
    }
}

