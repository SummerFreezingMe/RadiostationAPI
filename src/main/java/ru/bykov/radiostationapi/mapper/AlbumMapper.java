package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.in.AlbumDto;
import ru.bykov.radiostationapi.domain.dto.out.GetAlbumDto;


@Mapper(componentModel = "spring")
public interface AlbumMapper {
    GetAlbumDto toDto(Album client);
    Album toEntity(AlbumDto dto);
}
