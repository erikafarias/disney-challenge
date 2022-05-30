package com.alkemy.disney.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull @PositiveOrZero
    private Integer age;

    @NotNull @Positive
    private Double weight;

    @NotNull
    private String history;

    @ManyToMany
            (mappedBy = "characters",
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })
    private List<MovieEntity> movies = new ArrayList<>();


    public CharacterEntity(String name, Integer age, Double weight, String history) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
    }
}
