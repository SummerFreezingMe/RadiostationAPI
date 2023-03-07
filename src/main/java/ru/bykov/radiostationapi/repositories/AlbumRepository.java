package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Album;
@Repository
public interface AlbumRepository extends CrudRepository<Album,Long> {
    Album findByAlbumId(Long id);
}
