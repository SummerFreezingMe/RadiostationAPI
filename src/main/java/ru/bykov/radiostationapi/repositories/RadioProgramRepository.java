package ru.bykov.radiostationapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.bykov.radiostationapi.domain.RadioProgram;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public class RadioProgramRepository  {
    @Autowired
    public RadioProgramRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public RadioProgram findRadioProgramByStartingDateOrderByStartingDate(LocalDateTime now) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM radio_program WHERE starting_date<? " +
                        "ORDER BY starting_date DESC",
                BeanPropertyRowMapper.newInstance(RadioProgram.class), now);
    }

    public RadioProgram findByProgramTypeAndStartingDateAndProgramName(String program, LocalDateTime ldt, String programName) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM radio_program WHERE program_type=?1 AND starting_date=?2 " +
                        "AND program_type=?3",
                BeanPropertyRowMapper.newInstance(RadioProgram.class), program,ldt,programName);
    }


    private final JdbcTemplate jdbcTemplate;



    public RadioProgram findByProgramId(Long id) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT * FROM radio_program WHERE program_id=?",
                    BeanPropertyRowMapper.newInstance(RadioProgram.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void save(RadioProgram radioProgram) {
        jdbcTemplate.update("INSERT INTO radio_program ("+
                        "program_id,program_type,length,starting_date,program_name)" +
                        "VALUES(?,?,?,?,?)",
                    count()+1, radioProgram.getProgramType(),radioProgram.getLength(),
                radioProgram.getStartingDate(), radioProgram.getProgramName());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update(
                "DELETE FROM radio_program WHERE program_id=?", id);
    }


    public List<RadioProgram> findAll() {
        return jdbcTemplate.query("SELECT * from music_piece",
                BeanPropertyRowMapper.newInstance(RadioProgram.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM radio_program", Integer.class);

    }

}
