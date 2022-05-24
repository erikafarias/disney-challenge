package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String image;

    @OneToMany(mappedBy = "genre", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<MovieEntity> movies;





}