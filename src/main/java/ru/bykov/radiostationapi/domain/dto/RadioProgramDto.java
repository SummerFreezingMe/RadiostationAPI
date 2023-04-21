package ru.bykov.radiostationapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
@Transactional
public class RadioProgramDto {
     private String programName;

    private String programType;

    private LocalDateTime startingDate;

  }
