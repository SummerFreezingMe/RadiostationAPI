package ru.bykov.radiostationapi.mapper;

import org.mapstruct.Mapper;
import ru.bykov.radiostationapi.domain.RadioProgram;
import ru.bykov.radiostationapi.domain.dto.in.RadioProgramDto;
import ru.bykov.radiostationapi.domain.dto.out.GetRadioProgramDto;

@Mapper(componentModel = "spring")
public interface RadioProgramMapper {
    GetRadioProgramDto toDto(RadioProgram client);
    RadioProgram toEntity(RadioProgramDto dto);
}
