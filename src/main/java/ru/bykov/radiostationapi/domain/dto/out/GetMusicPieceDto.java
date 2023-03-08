package ru.bykov.radiostationapi.domain.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMusicPieceDto {

    private String title;

    private String author;

    private String performer;

    private String albumName;

    private Integer albumYear;

    private Long genreId;

    private Integer pieceLength;

    private Float rating;
}
