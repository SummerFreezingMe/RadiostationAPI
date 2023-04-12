package ru.bykov.radiostationapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.MusicPiece;

import java.util.List;

@Repository
public class MusicPieceRepository {
@Autowired
    public MusicPieceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MusicPiece> findByAlbumName(Long albumName) {
         return jdbcTemplate.query(
                "SELECT * FROM music_piece WHERE album_id=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), albumName);
    }

    public List<MusicPiece> findByAuthor(Long author) {
        return jdbcTemplate.query(
                "SELECT * FROM music_piece WHERE author_id=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), author);
    }

    public List<MusicPiece> findByGenreId(Long genre) {
        return jdbcTemplate.query(
                "SELECT * FROM music_piece WHERE genre_id=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), genre);
    }


    private final JdbcTemplate jdbcTemplate;



    public MusicPiece findByPieceId(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM music_piece WHERE piece_id=?",
                    BeanPropertyRowMapper.newInstance(MusicPiece.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(MusicPiece musicPiece) {
        jdbcTemplate.update("INSERT INTO music_piece ("+
                        "piece_id,title,album_id,genre_id,piece_length,"+
                        " rating,author_id,performer_id)VALUES(?,?,?,?,?,?,?,?)",
                count()+1, musicPiece.getPieceLength(),musicPiece.getAuthorId(),musicPiece.getPerformerId(),
                musicPiece.getAlbumId(),musicPiece.getGenreId(),musicPiece.getPieceLength(),
                musicPiece.getRating());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(
                "DELETE FROM music_piece WHERE genre_id=?", id);
    }


    public List<MusicPiece> findAll() {
        return jdbcTemplate.query("SELECT * from music_piece",
                BeanPropertyRowMapper.newInstance(MusicPiece.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM music_piece", Integer.class);

    }


}
