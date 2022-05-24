package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private Double weight;

    private String history;

    @ManyToMany
            (mappedBy = "characters",
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                })

    private List<MovieEntity> movies = new ArrayList<>();

}
