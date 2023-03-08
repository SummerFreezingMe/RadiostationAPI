package ru.bykov.radiostationapi.domain.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumDto {

    private String albumTitle;

    private Integer albumYear;

    private Long artistId;
}
