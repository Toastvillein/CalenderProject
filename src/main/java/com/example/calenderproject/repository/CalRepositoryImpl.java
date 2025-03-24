package com.example.calenderproject.repository;

import com.example.calenderproject.domain.Calender;
import com.example.calenderproject.dto.CalRequestDto;
import com.example.calenderproject.dto.CalResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class CalRepositoryImpl implements CalRepository {

    private final JdbcTemplate jdbcTemplate;

    public CalRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CalResponseDto createCal(Calender calender) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("calender").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",calender.getName());
        parameters.put("todo",calender.getToDo());
        parameters.put("password",calender.getPassword());
        parameters.put("updatetime", LocalDateTime.now());

        Number key = jdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource(parameters));


        return new CalResponseDto(key.longValue(),calender.getName(),calender.getPassword(),calender.getToDo(), LocalDate.now());
    }

    @Override
    public Optional<Calender> findCalByID(Long id) {
        List<Calender> result = jdbcTemplate.query(
                "select * from calender where id = ?", calRowMapperV1(),id);
        return result.stream().findAny();
    }

    @Override
    public List<CalResponseDto> findAllCal() {
        return jdbcTemplate.query(
                "select id,name,password,todo,updatetime from calender ORDER BY 5 DESC",calRowMapperV2());
    }

    private RowMapper<Calender> calRowMapperV1(){
        return new RowMapper<Calender>() {
            @Override
            public Calender mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Calender(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("password"),
                        rs.getString("todo"),
                        rs.getTimestamp("updatetime").toLocalDateTime().toLocalDate());
            }
        };
    }

    private RowMapper<CalResponseDto> calRowMapperV2(){
        return new RowMapper<CalResponseDto>() {
            @Override
            public CalResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new CalResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("password"),
                        rs.getString("todo"),
                        rs.getTimestamp("updatetime").toLocalDateTime().toLocalDate()
                );
            }
        };
    }


}
