package ru.bykov.radiostationapi.service.impl;

import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.RadioProgram;
import ru.bykov.radiostationapi.repositories.RadioProgramRepository;
import ru.bykov.radiostationapi.service.RadioProgramService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class RadioProgramServiceImpl implements RadioProgramService {

    private final RadioProgramRepository radioProgramRepository;

    public RadioProgramServiceImpl(RadioProgramRepository radioProgramRepository) {
        this.radioProgramRepository = radioProgramRepository;
    }

    public Map<String, String> createRadioProgram(Map<String, String> payload) {
        Map<String, String> data = new HashMap<>();
        RadioProgram newProgram = new RadioProgram(
                Long.valueOf(payload.get("program_id")), payload.get("program_name"),
                payload.get("program_type"), 0,
                LocalDate.parse(payload.get("starting_date")));
        radioProgramRepository.save(newProgram);
        data.put("status", "200");
        return data;
    }

    public RadioProgram getCurrentRadioProgram() {
        return radioProgramRepository.findRadioProgramByStartingDateOrderByStartingDate(
                LocalDate.now());
    }
}
