package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.ArtistDto;
import ru.bykov.radiostationapi.service.impl.ArtistServiceImpl;

import java.util.Map;

@RestController
public class ArtistController {

    private final ArtistServiceImpl as;


    public ArtistController(ArtistServiceImpl as) {
        this.as = as;
    }

    @PostMapping(value = "/add_artist", produces = {"application/json", "application/xml"})
    public Map<String, String> addArtist(@RequestBody ArtistDto artist) {
        return as.addArtist(artist);
    }

    @GetMapping(value = "/get_current_program/{id}", produces = {"application/json", "application/xml"})
    public Artist getCurrentProgram(@PathVariable Long id) {
        return as.getArtist(id);
    }

    @DeleteMapping(value = "/delete_program/{id}",
            produces = {"application/json", "application/xml"})
    public Map<String, String> deleteRadioProgram(
            @PathVariable Long id) {
        return as.deleteArtist(id);
    }
}

