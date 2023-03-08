package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.MusicPiece;
import ru.bykov.radiostationapi.domain.dto.MusicPieceDto;

@Mapper(componentModel = "spring")
public interface MusicPieceMapper {
    MusicPieceDto toDto(MusicPiece client);
    MusicPiece toEntity(MusicPieceDto dto);
}
