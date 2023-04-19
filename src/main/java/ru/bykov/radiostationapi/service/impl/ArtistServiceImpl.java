package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.ArtistDto;
import ru.bykov.radiostationapi.mapper.ArtistMapper;
import ru.bykov.radiostationapi.repositories.ArtistRepository;
import ru.bykov.radiostationapi.service.ArtistService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository ar;

    private final ArtistMapper artistMapper;
    @Autowired
    public ArtistServiceImpl(ArtistRepository ar, ArtistMapper artistMapper) {
        this.ar = ar;
        this.artistMapper = artistMapper;
    }

    public ArtistDto addArtist(ArtistDto artist) {
        Artist addition = new Artist(artist.getArtistName());
        ar.save(addition);
        return artistMapper.toDto(addition);
    }

    public ArtistDto getArtist(Long id) {
        return artistMapper.toDto(ar.findByArtistId(id));
    }


    public Map<String, String> deleteArtist(Long id) {
        ar.deleteById(id);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }
}
