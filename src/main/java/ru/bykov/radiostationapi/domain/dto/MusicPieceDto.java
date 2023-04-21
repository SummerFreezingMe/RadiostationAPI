package ru.bykov.radiostationapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
@Transactional
public class MusicPieceDto {
    private String title;

    private Long authorId;

    private Long performerId;

    private Long albumId;

    private Long genreId;

    private Integer pieceLength;

   }
