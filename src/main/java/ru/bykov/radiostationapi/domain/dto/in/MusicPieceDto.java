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


    private Long authorId;


    private Long performerId;


    private Long albumId;



    private Long genreId;


    private Integer pieceLength;


    private Float rating;

}
