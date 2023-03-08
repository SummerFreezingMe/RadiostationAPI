package ru.bykov.radiostationapi.controllers;

import org.springframework.web.bind.annotation.*;
import ru.bykov.radiostationapi.domain.dto.in.GenreDto;
import ru.bykov.radiostationapi.domain.dto.out.GetGenreDto;
import ru.bykov.radiostationapi.service.impl.GenreServiceImpl;

@RestController
public class GenreController {

    private final GenreServiceImpl gs;

    public GenreController(GenreServiceImpl as) {
        this.gs = as;
    }

    @PostMapping(value = "/add_genre", produces = {"application/json", "application/xml"})
    public GetGenreDto addGenre(@RequestBody GenreDto genre) {
        return gs.addGenre(genre);
    }

    @GetMapping(value = "/get_genre/{id}", produces = {"application/json", "application/xml"})
    public GetGenreDto getGenre(@PathVariable Long id) {
        return gs.getGenre(id);
    }

    @DeleteMapping(value = "/delete_genre/{id}",
            produces = {"application/json", "application/xml"})
    public GetGenreDto deleteAlbum(@PathVariable Long id) {
        return gs.deleteGenre(id);
    }
}
