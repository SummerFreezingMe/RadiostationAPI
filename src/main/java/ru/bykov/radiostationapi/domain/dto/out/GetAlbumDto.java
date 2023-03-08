package ru.bykov.radiostationapi.domain.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAlbumDto {

    private String albumTitle;

    private Integer albumYear;

    private Long artistId;
}
