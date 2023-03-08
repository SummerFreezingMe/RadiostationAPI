package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.GenreDto;
import ru.bykov.radiostationapi.mapper.GenreMapper;
import ru.bykov.radiostationapi.repositories.GenreRepository;
import ru.bykov.radiostationapi.service.GenreService;

import java.util.HashMap;
import java.util.Map;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository gr;
    private final GenreMapper gm;
    @Autowired
    public GenreServiceImpl(GenreRepository gr, GenreMapper gm) {
        this.gr = gr;
        this.gm = gm;
    }

    public Map<String, String> deleteGenre(Long id) {
        Genre deleted = gr.findByGenreId(id);
        gr.delete(deleted);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public Genre getGenre(Long id) {
        return gr.findByGenreId(id);
    }

    public Map<String, String> addGenre(GenreDto genre) {
        Genre newGenre = gm.toEntity(genre);
        gr.save(newGenre);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }
}
