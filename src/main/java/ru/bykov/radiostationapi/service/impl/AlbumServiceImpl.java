package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.in.AlbumDto;
import ru.bykov.radiostationapi.domain.dto.out.GetAlbumDto;
import ru.bykov.radiostationapi.mapper.AlbumMapper;
import ru.bykov.radiostationapi.repositories.AlbumRepository;
import ru.bykov.radiostationapi.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
private final AlbumRepository ar;
private final AlbumMapper am;
@Autowired
    public AlbumServiceImpl(AlbumRepository ar, AlbumMapper am) {
        this.ar = ar;
    this.am = am;
}

    public GetAlbumDto addAlbum(AlbumDto album) {
        Album newArtist = am.toEntity(album);
        ar.save(newArtist);
        return am.toDto(newArtist);
    }

        public GetAlbumDto deleteAlbum(Long id) {
        Album deleted = ar.findByAlbumId(id);
        ar.delete(deleted);
        return am.toDto(deleted);
    }

    public GetAlbumDto getAlbum(Long id) {
    return am.toDto(ar.findByAlbumId(id));
    }
}
