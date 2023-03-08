package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.in.GenreDto;
import ru.bykov.radiostationapi.domain.dto.out.GetGenreDto;
import ru.bykov.radiostationapi.mapper.GenreMapper;
import ru.bykov.radiostationapi.repositories.GenreRepository;
import ru.bykov.radiostationapi.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository gr;
    private final GenreMapper gm;
    @Autowired
    public GenreServiceImpl(GenreRepository gr, GenreMapper gm) {
        this.gr = gr;
        this.gm = gm;
    }

    public GetGenreDto deleteGenre(Long id) {
        Genre deleted = gr.findByGenreId(id);
        gr.delete(deleted);
        return gm.toDto(deleted);
    }

    public GetGenreDto getGenre(Long id) {
        return gm.toDto(gr.findByGenreId(id));
    }

    public GetGenreDto addGenre(GenreDto genre) {
        Genre newGenre = gm.toEntity(genre);
        gr.save(newGenre);
        return gm.toDto(newGenre);
    }
}
