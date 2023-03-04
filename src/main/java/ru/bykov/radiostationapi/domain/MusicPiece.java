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
@Table(name = "music_pieces")
public class MusicPiece {
    @Id
    @Column(name = "piece_id")
    private Long pieceId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "performer")
    private String performer;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_year")
    private Integer albumYear;

    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "piece_length")
    private Integer pieceLength;

    @Column(name = "rating")
    private Float rating;
}
