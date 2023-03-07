package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Artist;
@Repository
public interface ArtistRepository  extends CrudRepository<Artist,Long> {
    Artist findByArtistId(Long id);
}
