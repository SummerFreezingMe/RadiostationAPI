package ru.bykov.radiostationapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MusicPiece {
    @Id
    private Long pieceId;

    private String title;

    private String author;

    private String performer;

    private String albumName;

    private Integer albumYear;


    private Long genreId;

    private Integer pieceLength;

    private Float rating;
}
