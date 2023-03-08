package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.in.GenreDto;
import ru.bykov.radiostationapi.domain.dto.out.GetGenreDto;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GetGenreDto toDto(Genre client);
    Genre toEntity(GenreDto dto);
}
