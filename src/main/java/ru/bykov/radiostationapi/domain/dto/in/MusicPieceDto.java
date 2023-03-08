package ru.bykov.radiostationapi.domain.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MusicPieceDto {

    private String title;

    private String author;

    private String performer;

    private String albumName;

    private Integer albumYear;

    private Long genreId;

    private Integer pieceLength;

}
