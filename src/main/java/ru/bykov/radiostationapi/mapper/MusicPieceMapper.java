package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.MusicPiece;
import ru.bykov.radiostationapi.domain.dto.in.MusicPieceDto;
import ru.bykov.radiostationapi.domain.dto.out.GetMusicPieceDto;

@Mapper(componentModel = "spring")
public interface MusicPieceMapper {
    GetMusicPieceDto toDto(MusicPiece client);
    MusicPiece toEntity(MusicPieceDto dto);
}
