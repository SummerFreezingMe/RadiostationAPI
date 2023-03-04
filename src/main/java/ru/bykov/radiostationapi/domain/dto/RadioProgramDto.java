package ru.bykov.radiostationapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RadioProgramDto {
    private Long programId;

    private String programName;

    private String programType;

    private String startingDate;
}
