package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "music_pieces")
public class MusicPiece {
    public MusicPiece(String title, String author, String performer, String albumName, Integer albumYear, Long genreId, Integer pieceLength, Float rating) {
        this.title = title;
        this.author = author;
        this.performer = performer;
        this.albumName = albumName;
        this.albumYear = albumYear;
        this.genreId = genreId;
        this.pieceLength = pieceLength;
        this.rating = rating;
    }

    @Id
    @Column(name = "piece_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
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
