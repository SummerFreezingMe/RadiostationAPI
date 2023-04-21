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
public class AlbumDto {

    private String albumTitle;

    private Integer albumYear;

    private Long artistId;

  }
