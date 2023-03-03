package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bykov.radiostationapi.service.impl.RadioProgramServiceImpl;

import java.util.Map;
@RestController
public class RadioProgramController {
    private final RadioProgramServiceImpl rps;



    public RadioProgramController(RadioProgramServiceImpl rps) {
        this.rps = rps;
    }

    @RequestMapping(value = "/add_program", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    public Map<String, String> addRadioProgram(@RequestBody Map<String, String> payload) {
        return rps.createRadioProgram(payload);
    }
}
