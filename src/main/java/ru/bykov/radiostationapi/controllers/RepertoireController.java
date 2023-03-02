package ru.bykov.radiostationapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bykov.radiostationapi.service.impl.RepertoireServiceImpl;

import java.util.Map;

@Controller
public class RepertoireController {

    private final RepertoireServiceImpl sas;

    @Autowired
    public RepertoireController(RepertoireServiceImpl sas) {
        this.sas = sas;
    }

    @RequestMapping(value = "/incoming_call", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public Map<String, String> receiveIncomingCall(@RequestParam String musicPieceId) {
        return sas.fetchIncomingCall(musicPieceId);
    }


    @RequestMapping(value = "/add_music", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    public Map<String, String> addMusicPiece(@RequestBody Map<String, String> payload) {
        return sas.addMusicPiece(payload);
    }
}
