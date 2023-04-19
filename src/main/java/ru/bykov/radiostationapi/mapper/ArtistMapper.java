package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.ArtistDto;


@Mapper(componentModel = "spring")
public interface ArtistMapper {
    ArtistDto toDto(Artist client);
    Artist toEntity(ArtistDto dto);
}
