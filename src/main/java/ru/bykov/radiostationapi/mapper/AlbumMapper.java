package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.AlbumDto;


@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumDto toDto(Album client);
    Album toEntity(AlbumDto dto);
}
