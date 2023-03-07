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

    public List<MusicPiece> findByAlbumName(String albumName) {
         return jdbcTemplate.query(
                "SELECT * FROM music_pieces WHERE album_name=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), albumName);
    }

    public List<MusicPiece> findByAuthor(String author) {
        return jdbcTemplate.query(
                "SELECT * FROM music_pieces WHERE author=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), author);
    }

    public List<MusicPiece> findByGenreId(Long genre) {
        return jdbcTemplate.query(
                "SELECT * FROM music_pieces WHERE genre_id=?",
                BeanPropertyRowMapper.newInstance(MusicPiece.class), genre);
    }


    private final JdbcTemplate jdbcTemplate;



    public MusicPiece findByPieceId(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM music_pieces WHERE piece_id=?",
                    BeanPropertyRowMapper.newInstance(MusicPiece.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(MusicPiece genre) {
        jdbcTemplate.update("INSERT INTO music_pieces ("+
                        "piece_id,title,author,performer,album_name,album_year,genre_id,piece_length,"+
                        " rating)VALUES(?,?,?,?,?,?,?,?,?)",
                count()+1, genre.getPieceLength(),genre.getAuthor(),genre.getPerformer(),
                genre.getAlbumName(),genre.getAlbumYear(),genre.getGenreId(),genre.getPieceLength(),
                genre.getRating());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(
                "DELETE FROM music_pieces WHERE genre_id=?", id);
    }


    public List<MusicPiece> findAll() {
        return jdbcTemplate.query("SELECT * from music_pieces",
                BeanPropertyRowMapper.newInstance(MusicPiece.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM music_pieces", Integer.class);

    }


}
