package ru.bykov.radiostationapi.repositories;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Album;
import ru.bykov.radiostationapi.domain.Artist;

import java.util.List;
@Repository
public class ArtistRepository  {
    private final JdbcTemplate jdbcTemplate;

    public ArtistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Artist findByArtistId(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM artists WHERE artist_id=?",
                    BeanPropertyRowMapper.newInstance(Artist.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Artist artist) {
        jdbcTemplate.update("INSERT INTO artists (artist_id, artist_name) " +
                        "VALUES(?,?)",
                count()+1, artist.getArtistName());
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE from artists");
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM artists WHERE artist_id=?", id);
    }


    public List<Album> findAll() {
        return jdbcTemplate.query("SELECT * from artists",
                BeanPropertyRowMapper.newInstance(Album.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM albums", Integer.class);

    }
}
