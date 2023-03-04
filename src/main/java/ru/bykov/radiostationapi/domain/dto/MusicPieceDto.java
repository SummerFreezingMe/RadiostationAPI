package ru.bykov.radiostationapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MusicPieceDto {
    private Long pieceId;

    private String title;

    private String author;

    private String performer;

    private String albumName;

    private Integer albumYear;

    private Long genreId;

    private Integer pieceLength;

}
