package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {
    Genre findByGenreId(Long id);
}
