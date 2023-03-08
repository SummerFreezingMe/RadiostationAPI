package ru.bykov.radiostationapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.dto.in.MusicPieceDto;
import ru.bykov.radiostationapi.domain.dto.out.GetMusicPieceDto;
import ru.bykov.radiostationapi.service.impl.RepertoireServiceImpl;

import java.util.Map;

@RestController
public class RepertoireController {

    private final RepertoireServiceImpl sas;

    @Autowired
    public RepertoireController(RepertoireServiceImpl sas) {
        this.sas = sas;
    }

    @GetMapping(value = "/incoming_call", produces = {"application/json", "application/xml"})
    public GetMusicPieceDto receiveIncomingCall(@RequestParam Map<String, String> payload) {
        return  sas.fetchIncomingCall(payload);
    }


    @PostMapping(value = "/add_music", produces = {"application/json", "application/xml"})
    public GetMusicPieceDto addMusicPiece(@RequestBody MusicPieceDto musicPiece) {
        return sas.addMusicPiece(musicPiece);

    }
    @DeleteMapping(value = "/delete_music/{id}", produces = {"application/json", "application/xml"})
    public GetMusicPieceDto deleteRadioProgram(@PathVariable Long id) {
        return sas.deleteMusicPiece(id);
    }
}

