package ru.bykov.radiostationapi.domain.dto.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RadioProgramDto {

    private String programName;

    private String programType;

    private LocalDateTime startingDate;
}
