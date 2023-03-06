package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bykov.radiostationapi.domain.RadioProgram;

import java.time.LocalDateTime;

public interface RadioProgramRepository extends CrudRepository<RadioProgram,Long> {
    RadioProgram findRadioProgramByStartingDateOrderByStartingDate(LocalDateTime now);

    RadioProgram findByProgramTypeAndStartingDateAndProgramName(String program, LocalDateTime ldt, String programName);

    RadioProgram findByProgramId(Long id);
}
