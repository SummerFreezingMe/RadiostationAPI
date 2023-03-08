package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.in.ArtistDto;
import ru.bykov.radiostationapi.domain.dto.out.GetArtistDto;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    GetArtistDto toDto(Artist client);
    Artist toEntity(ArtistDto dto);
}
