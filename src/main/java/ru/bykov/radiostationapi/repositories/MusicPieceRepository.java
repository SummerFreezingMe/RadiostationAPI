package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.MusicPiece;

@Repository
public interface MusicPieceRepository extends CrudRepository<MusicPiece, Long> {
}
