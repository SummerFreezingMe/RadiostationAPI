package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.RadioProgram;

import java.time.LocalDateTime;
@Repository
public interface RadioProgramRepository extends CrudRepository<RadioProgram,Long> {
    RadioProgram findRadioProgramByStartingDateOrderByStartingDate(LocalDateTime now);

    RadioProgram findByProgramTypeAndStartingDateAndProgramName(String program, LocalDateTime ldt, String programName);

    RadioProgram findByProgramId(Long id);
}
