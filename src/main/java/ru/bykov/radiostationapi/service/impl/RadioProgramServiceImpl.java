package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.RadioProgram;
import ru.bykov.radiostationapi.domain.dto.in.RadioProgramDto;
import ru.bykov.radiostationapi.mapper.RadioProgramMapper;
import ru.bykov.radiostationapi.repositories.RadioProgramRepository;
import ru.bykov.radiostationapi.service.RadioProgramService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class RadioProgramServiceImpl implements RadioProgramService {

    private final RadioProgramRepository radioProgramRepository;
    private final RadioProgramMapper rpm;
    @Autowired
    public RadioProgramServiceImpl(RadioProgramRepository radioProgramRepository, RadioProgramMapper rpm) {
        this.radioProgramRepository = radioProgramRepository;
        this.rpm = rpm;
    }

    public Map<String, String> createRadioProgram(RadioProgramDto program) {
        Map<String, String> data = new HashMap<>();
        RadioProgram newProgram = rpm.toEntity(program);
        radioProgramRepository.save(newProgram);
        data.put("status", "200");
        return data;
    }

    public RadioProgram getCurrentRadioProgram() {
        return radioProgramRepository.findRadioProgramByStartingDateOrderByStartingDate(
                LocalDateTime.now());
    }

    public Map<String, String> deleteRadioProgram(RadioProgramDto radioProgram) {
        Map<String, String> data = new HashMap<>();
            RadioProgram deleted = radioProgramRepository.findByProgramTypeAndStartingDateAndProgramName(
                radioProgram.getProgramType(),radioProgram.getStartingDate(),
                radioProgram.getProgramName());
    radioProgramRepository.delete(deleted);
        data.put("status", "200");
        return data;

    }

    public RadioProgram getRadioProgram(Long id) {
        return radioProgramRepository.findByProgramId(id);}
}
