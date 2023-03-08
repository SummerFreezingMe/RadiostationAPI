package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.RadioProgram;
import ru.bykov.radiostationapi.domain.dto.in.RadioProgramDto;
import ru.bykov.radiostationapi.service.impl.RadioProgramServiceImpl;

import java.util.Map;
@RestController
public class RadioProgramController {
    private final RadioProgramServiceImpl rps;



    public RadioProgramController(RadioProgramServiceImpl rps) {
        this.rps = rps;
    }

    @PostMapping(value = "/add_program", produces = {"application/json", "application/xml"})
    public Map<String, String> addRadioProgram(@RequestBody RadioProgramDto radioProgram) {
        return rps.createRadioProgram(radioProgram);
    }

    @GetMapping(value = "/get_current_program",
            produces = {"application/json", "application/xml"})
    public RadioProgram getCurrentProgram() {
        return rps.getCurrentRadioProgram();
    }

    @GetMapping(value = "/get_program/{id}",
            produces = {"application/json", "application/xml"})
    public RadioProgram getProgram(@PathVariable Long id) {
        return rps.getRadioProgram(id);
    }

    @DeleteMapping(value = "/delete_program", produces = {"application/json", "application/xml"})
    public Map<String, String> deleteRadioProgram(@RequestBody RadioProgramDto radioProgram) {
        return rps.deleteRadioProgram(radioProgram);
    }
}
