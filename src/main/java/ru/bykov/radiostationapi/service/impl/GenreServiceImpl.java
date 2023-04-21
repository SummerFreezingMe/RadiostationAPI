package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Genre;
import ru.bykov.radiostationapi.domain.dto.GenreDto;
import ru.bykov.radiostationapi.mapper.GenreMapper;
import ru.bykov.radiostationapi.repositories.GenreRepository;
import ru.bykov.radiostationapi.service.GenreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository gr;
    private final GenreMapper genreMapper;

    @Autowired
    public GenreServiceImpl(GenreRepository gr, GenreMapper genreMapper) {
        this.gr = gr;
        this.genreMapper = genreMapper;
    }

    public Map<String, String> deleteGenre(Long id) {
        gr.deleteById(id);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public GenreDto getGenre(Long id) {
        return genreMapper.toDto(gr.findByGenreId(id));
    }

    public GenreDto addGenre(GenreDto genre) {
        Genre newGenre = new Genre(genre.getGenreName(), 0f);
        gr.save(newGenre);
        return genreMapper.toDto(newGenre);
    }

    public List<GenreDto> findAll() {
        return gr.findAll().stream().map(genreMapper::toDto).collect(Collectors.toList());
    }
}
