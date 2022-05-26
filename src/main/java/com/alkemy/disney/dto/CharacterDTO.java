package com.alkemy.disney.dto;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterDTO {
    private Long id;
    private String name;
    private Integer age;
    private Double weight;
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

