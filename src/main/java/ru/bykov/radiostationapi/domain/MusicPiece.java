package ru.bykov.radiostationapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "music_piece")
public class MusicPiece {

    @Id
    @Column(name = "piece_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pieceId;

    @Column(name = "title")
    private String title;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "performer_id")
    private Long performerId;

    @Column(name = "album_id")
    private Long albumId;


    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "piece_length")
    private Integer pieceLength;

    @Column(name = "rating")
    private Float rating;
}

