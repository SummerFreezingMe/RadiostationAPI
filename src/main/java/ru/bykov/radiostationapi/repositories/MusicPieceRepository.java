package ru.bykov.radiostationapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.MusicPiece;

import java.util.Optional;

@Repository
public interface MusicPieceRepository extends CrudRepository<MusicPiece, Long> {
    Optional<MusicPiece> findByAlbumName(String albumName);

    Optional<MusicPiece> findByAuthor(String author);

    Optional<MusicPiece> findByGenreId(Long genre);


    MusicPiece findByPieceId(Long musicPieceId);
}
