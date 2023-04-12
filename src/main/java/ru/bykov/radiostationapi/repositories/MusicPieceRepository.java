package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.MusicPiece;

import java.util.Optional;

@Repository
public interface MusicPieceRepository extends CrudRepository<MusicPiece, Long> {
    Optional<MusicPiece> findByAlbumId(Long albumId);

    Optional<MusicPiece> findByAuthorId(Long author);

    Optional<MusicPiece> findByGenreId(Long genre);


    MusicPiece findByPieceId(Long musicPieceId);
}
