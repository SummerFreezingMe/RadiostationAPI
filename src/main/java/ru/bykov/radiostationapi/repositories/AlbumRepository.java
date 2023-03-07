package ru.bykov.radiostationapi.repositories;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Album;

import java.util.List;

@Repository
public class AlbumRepository {
    private final JdbcTemplate jdbcTemplate;

    public AlbumRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Album findByAlbumId(Long id) {
        try {
            Album album = jdbcTemplate.queryForObject(
                    "SELECT * FROM albums WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Album.class), id);

            return album;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Album album) {
        jdbcTemplate.update("INSERT INTO albums (album_id, album_title, " +
                        "album_year,artist_id) VALUES(?,?,?,?)",
                count()+1, album.getAlbumTitle(), album.getAlbumYear(),
                album.getArtistId());
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE from albums");
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM albums WHERE id=?", id);
    }


    public List<Album> findAll() {
        return jdbcTemplate.query("SELECT * from albums",
                BeanPropertyRowMapper.newInstance(Album.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM albums", Integer.class);

    }
}