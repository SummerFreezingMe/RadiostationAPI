package ru.bykov.radiostationapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.dto.MusicPieceDto;
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
    public ResponseEntity<String> receiveIncomingCall(@RequestParam Map<String, String> payload) {
         sas.fetchIncomingCall(payload);
        return new ResponseEntity<>(sas.fetchIncomingCall(payload), HttpStatus.OK);
    }


    @PostMapping(value = "/add_music", produces = {"application/json", "application/xml"})
    public Map<String, String> addMusicPiece(@RequestBody MusicPieceDto musicPiece) {
        return sas.addMusicPiece(musicPiece);

    }
    @DeleteMapping(value = "/delete_music/{id}", produces = {"application/json", "application/xml"})
    public Map<String, String> deleteRadioProgram(@PathVariable Long id) {
        return sas.deleteMusicPiece(id);
    }
}

