package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.dto.in.AlbumDto;
import ru.bykov.radiostationapi.domain.dto.out.GetAlbumDto;
import ru.bykov.radiostationapi.service.impl.AlbumServiceImpl;

@RestController
public class AlbumController {
    private final AlbumServiceImpl as;

    public AlbumController(AlbumServiceImpl as) {
        this.as = as;
    }

    @PostMapping(value = "/add_album", produces = {"application/json", "application/xml"})
    public GetAlbumDto addAlbum(@RequestBody AlbumDto album) {
        return as.addAlbum(album);
    }

    @GetMapping(value = "/get_album/{id}", produces = {"application/json", "application/xml"})
    public GetAlbumDto getAlbum(@PathVariable Long id) {
        return as.getAlbum(id);
    }

    @DeleteMapping(value = "/delete_album/{id}",
            produces = {"application/json", "application/xml"})
    public GetAlbumDto deleteAlbum(@PathVariable Long id) {
        return as.deleteAlbum(id);
    }
}
