package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = generationType.SEQUENCE)
    private Long id;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<Movie>();
}
