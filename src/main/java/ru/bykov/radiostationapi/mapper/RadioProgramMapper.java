package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.RadioProgram;
import ru.bykov.radiostationapi.domain.dto.RadioProgramDto;

@Mapper(componentModel = "spring")
public interface RadioProgramMapper {
    RadioProgramDto toDto(RadioProgram client);
    RadioProgram toEntity(RadioProgramDto dto);
}
