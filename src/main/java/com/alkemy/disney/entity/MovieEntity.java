package com.alkemy.disney.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String image;


    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;


    private int score;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", updatable = false, insertable = false)
    private GenreEntity genre;

    @Column(name = "genre_id")
    private Long genreId;

    private boolean deleted = Boolean.FALSE;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    @JsonIgnore
    private Set<CharacterEntity> characters = new HashSet<>();


    public MovieEntity(String image, String title, int score, GenreEntity genre,
                       Set<CharacterEntity> characters) {
        this.image = image;
        this.title = title;
        this.score = score;
        this.genre = genre;
        this.characters = characters;
    }

    public void addCharacter(CharacterEntity characterEntity){
        characters.add(characterEntity);
    }

    public void removeCharacter(CharacterEntity characterEntity) { characters.remove(characterEntity); }
}