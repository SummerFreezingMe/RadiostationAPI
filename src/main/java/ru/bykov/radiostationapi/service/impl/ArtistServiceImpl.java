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
    private final ArtistMapper am;
    @Autowired
    public ArtistServiceImpl(ArtistRepository ar, ArtistMapper am) {
        this.ar = ar;
        this.am = am;
    }

    public Map<String, String> addArtist(ArtistDto artist) {
        Map<String, String> data = new HashMap<>();
        Artist addition = am.toEntity(artist);
        ar.save(addition);
        data.put("status", "200");
        return data;
    }

    public Artist getArtist(Long id) {
        return ar.findByArtistId(id);
    }


    public Map<String, String> deleteArtist(Long id) {

        Artist deleted = ar.findByArtistId(id);
        ar.delete(deleted);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }
}
