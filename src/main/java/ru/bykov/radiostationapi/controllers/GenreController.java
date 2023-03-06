package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.GenreDto;
import ru.bykov.radiostationapi.service.impl.GenreServiceImpl;

import java.util.Map;

@RestController
public class GenreController {

    private final GenreServiceImpl gs;

    public GenreController(GenreServiceImpl as) {
        this.gs = as;
    }

    @PostMapping(value = "/add_genre", produces = {"application/json", "application/xml"})
    public Map<String, String> addGenre(@RequestBody GenreDto genre) {
        return gs.addGenre(genre);
    }

    @GetMapping(value = "/get_genre/{id}", produces = {"application/json", "application/xml"})
    public Genre getGenre(@PathVariable Long id) {
        return gs.getGenre(id);
    }

    @DeleteMapping(value = "/delete_genre/{id}",
            produces = {"application/json", "application/xml"})
    public Map<String, String> deleteAlbum(
            @PathVariable Long id) {
        return gs.deleteGenre(id);
    }
}
