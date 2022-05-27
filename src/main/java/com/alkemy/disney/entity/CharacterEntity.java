package com.alkemy.disney.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    @JsonIgnore
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
