package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.ArtistDto;
import ru.bykov.radiostationapi.repositories.ArtistRepository;
import ru.bykov.radiostationapi.service.ArtistService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository ar;

    @Autowired
    public ArtistServiceImpl(ArtistRepository ar) {
        this.ar = ar;
    }

    public Map<String, String> addArtist(ArtistDto artist) {
        Map<String, String> data = new HashMap<>();
        Artist addition = new Artist(artist.getArtistName());
        ar.save(addition);
        data.put("status", "200");
        return data;
    }

    public Artist getArtist(Long id) {
        return ar.findByArtistId(id);
    }


    public Map<String, String> deleteArtist(Long id) {
        ar.deleteById(id);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }
}
