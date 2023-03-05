package ru.bykov.radiostationapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.dto.ArtistDto;
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

    @RequestMapping(value = "/incoming_call", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<String> receiveIncomingCall(@RequestParam Map<String, String> payload) {
         sas.fetchIncomingCall(payload);
        return new ResponseEntity<>(sas.fetchIncomingCall(payload), HttpStatus.OK);
    }


    @RequestMapping(value = "/add_music", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    public Map<String, String> addMusicPiece(@RequestBody MusicPieceDto musicPiece) {
        return sas.addMusicPiece(musicPiece);

    }

    @RequestMapping(value = "/add_artist", method = RequestMethod.POST, produces = {"application/json", "application/xml"})
    public Map<String, String> addArtist(@RequestBody ArtistDto artist) {
        return sas.addArtist(artist);

    }

}
