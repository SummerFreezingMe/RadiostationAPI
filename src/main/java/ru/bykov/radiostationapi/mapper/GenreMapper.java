package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.GenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDto(Genre client);
    Genre toEntity(GenreDto dto);
}
