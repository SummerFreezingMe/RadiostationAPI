package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.AlbumDto;
import ru.bykov.radiostationapi.service.impl.AlbumServiceImpl;

import java.util.Map;

@RestController

public class AlbumController {
    private final AlbumServiceImpl as;


    public AlbumController(AlbumServiceImpl as) {
        this.as = as;
    }

    @PostMapping(value = "/add_album", produces = {"application/json", "application/xml"})
    public Map<String, String> addAlbum(@RequestBody AlbumDto album) {
        return as.addAlbum(album);
    }

    @GetMapping(value = "/get_album/{id}", produces = {"application/json", "application/xml"})
    public Album getAlbum(@PathVariable Long id) {
        return as.getAlbum(id);
    }

    @DeleteMapping(value = "/delete_album/{id}",
            produces = {"application/json", "application/xml"})
    public Map<String, String> deleteAlbum(
            @PathVariable Long id) {
        return as.deleteAlbum(id);
    }
}
