package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bykov.radiostationapi.domain.RadioProgram;

import java.time.LocalDate;

public interface RadioProgramRepository extends CrudRepository<RadioProgram,Long> {
    RadioProgram findRadioProgramByStartingDateOrderByStartingDate(LocalDate now);
}
