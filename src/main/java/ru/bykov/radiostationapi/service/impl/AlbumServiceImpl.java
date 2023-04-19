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

private final AlbumMapper albumMapper;
@Autowired
    public AlbumServiceImpl(AlbumRepository ar, AlbumMapper albumMapper) {
        this.ar = ar;
    this.albumMapper = albumMapper;
}

    public AlbumDto addAlbum(AlbumDto album) {
        Album newAlbum = new Album(album.getAlbumTitle(),
                album.getAlbumYear(),album.getArtistId());
        ar.save(newAlbum);

        return albumMapper.toDto(newAlbum);
    }

    public Map<String, String> deleteAlbum(Long id) {

        ar.deleteById(id);
        Map<String, String> data = new HashMap<>();
        data.put("status", "200");
        return data;
    }

    public AlbumDto getAlbum(Long id) {
    return albumMapper.toDto(ar.findByAlbumId(id));
    }
}
