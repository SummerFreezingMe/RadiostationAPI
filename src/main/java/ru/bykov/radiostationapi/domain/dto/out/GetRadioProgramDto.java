package ru.bykov.radiostationapi.domain.dto.out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetRadioProgramDto {

    private String programName;

    private String programType;

    private LocalDateTime startingDate;

}
