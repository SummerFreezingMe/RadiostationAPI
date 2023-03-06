package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bykov.radiostationapi.domain.Album;

public interface AlbumRepository extends CrudRepository<Album,Long> {
    Album findByAlbumId(Long id);
}
