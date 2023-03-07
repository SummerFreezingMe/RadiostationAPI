package ru.bykov.radiostationapi.repositories;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.Genre;

import java.util.List;

@Repository
public class GenreRepository {
    private final JdbcTemplate jdbcTemplate;

    public GenreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public  Genre findByGenreId(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM artists WHERE artist_id=?",
                    BeanPropertyRowMapper.newInstance(Genre.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(Genre genre) {
        jdbcTemplate.update("INSERT INTO genres (genre_id, genre_name,rating)"+
                        " VALUES(?,?,?)",
                count()+1, genre.getGenreName(),genre.getRating());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM genres WHERE genre_id=?", id);
    }


    public  List <Genre> findAll() {
        return jdbcTemplate.query("SELECT * from genres",
                BeanPropertyRowMapper.newInstance(Genre.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM genres", Integer.class);

    }
}
