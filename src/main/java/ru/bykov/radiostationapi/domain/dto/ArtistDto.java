package ru.bykov.radiostationapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Repository
@Transactional
public class ArtistDto {
    private JdbcTemplate jdbcTemplate;
    private String artistName;

    @Autowired
    public ArtistDto(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
