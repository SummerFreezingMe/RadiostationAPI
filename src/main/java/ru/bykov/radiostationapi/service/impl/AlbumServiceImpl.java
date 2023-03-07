package ru.bykov.radiostationapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.dto.AlbumDto;
import ru.bykov.radiostationapi.repositories.AlbumRepository;
import ru.bykov.radiostationapi.service.AlbumService;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {
private final AlbumRepository ar;
@Autowired
    public AlbumServiceImpl(AlbumRepository ar) {
        this.ar = ar;
    }

    public Map<String, String> addAlbum(AlbumDto album) {
        Album newAlbum = new Album(album.getAlbumTitle(),
                album.getAlbumYear(),album.getArtistId());
        ar.save(newAlbum);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public Map<String, String> deleteAlbum(Long id) {

        ar.deleteById(id);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public Album getAlbum(Long id) {
    return ar.findByAlbumId(id);
    }
}
