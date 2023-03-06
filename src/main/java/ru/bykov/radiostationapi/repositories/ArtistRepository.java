package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.bykov.radiostationapi.domain.Artist;

public interface ArtistRepository  extends CrudRepository<Artist,Long> {
    Artist findByArtistId(Long id);
}
