package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Artist;
import ru.bykov.radiostationapi.domain.dto.in.ArtistDto;
import ru.bykov.radiostationapi.domain.dto.out.GetArtistDto;
import ru.bykov.radiostationapi.mapper.ArtistMapper;
import ru.bykov.radiostationapi.repositories.ArtistRepository;
import ru.bykov.radiostationapi.service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository ar;
    private final ArtistMapper am;
    @Autowired
    public ArtistServiceImpl(ArtistRepository ar, ArtistMapper am) {
        this.ar = ar;
        this.am = am;
    }

    public GetArtistDto addArtist(ArtistDto artist) {
        Artist addition = am.toEntity(artist);
        ar.save(addition);
        return am.toDto(addition);
    }

    public GetArtistDto getArtist(Long id) {
        return am.toDto(ar.findByArtistId(id));
    }


    public GetArtistDto deleteArtist(Long id) {

        Artist deleted = ar.findByArtistId(id);
        ar.delete(deleted);
        return am.toDto(deleted);
    }
}
