package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.AlbumDto;
import ru.bykov.radiostationapi.mapper.AlbumMapper;
import ru.bykov.radiostationapi.repositories.AlbumRepository;
import ru.bykov.radiostationapi.service.AlbumService;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {
private final AlbumRepository ar;
private final AlbumMapper am;
@Autowired
    public AlbumServiceImpl(AlbumRepository ar, AlbumMapper am) {
        this.ar = ar;
    this.am = am;
}

    public Map<String, String> addAlbum(AlbumDto album) {
        Album newArtist = am.toEntity(album);
        ar.save(newArtist);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public Map<String, String> deleteAlbum(Long id) {
        Album deleted = ar.findByAlbumId(id);
        ar.delete(deleted);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public Album getAlbum(Long id) {
    return ar.findByAlbumId(id);
    }
}
