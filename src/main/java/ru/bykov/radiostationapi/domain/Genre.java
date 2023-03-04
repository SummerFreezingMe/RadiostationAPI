package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genre_id")
    private Long genreId;
    @Column(name = "genre_name")
    private String genreName;
    @Column(name = "rating")
    private Long rating;
}
