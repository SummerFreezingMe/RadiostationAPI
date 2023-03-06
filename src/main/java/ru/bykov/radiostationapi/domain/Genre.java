package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id")
    private Long genreId;

    public Genre(String genreName, Float rating) {
        this.genreName = genreName;
        this.rating = rating;
    }

    @Column(name = "genre_name")
    private String genreName;
    @Column(name = "rating")
    private Float rating;
}
