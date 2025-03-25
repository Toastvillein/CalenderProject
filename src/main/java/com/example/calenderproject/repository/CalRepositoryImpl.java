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

        Long calenderId = key.longValue();
        jdbcTemplate.update("INSERT INTO users(userid,name,updatetime) VALUES (?,?,?)",calenderId,calender.getName(),LocalDateTime.now());
        jdbcTemplate.update("update calender set userid = ? where id = ?",key,key);

        return new CalResponseDto(key.longValue(),calender.getName(),calender.getPassword(),calender.getToDo(),LocalDateTime.now().toLocalDate());
    }

    @Override
    public Optional<Calender> findCalByID(Long id) {
        List<Calender> result = jdbcTemplate.query(
                "select c.*,u.* from calender c join users u on c.userid=u.userid where c.id = ?", calRowMapperV1(),id);
        return result.stream().findAny();
    }

    @Override
    public List<CalResponseDto> findAllCal() {
        return jdbcTemplate.query(
                "select c.*,u.* from calender c Join users u on c.userid=u.userid ORDER BY c.updatetime DESC",calRowMapperV2());
    }

    @Override
    public int updateCal(Long id, Integer password, String name, String toDo) {
        return jdbcTemplate.update(
                "update calender set name = ?, todo = ? where id = ? and password = ?",
                name,toDo,id,password);
    }

    @Override
    public int deleteCal(Long id, Integer password) {
        return jdbcTemplate.update("delete from calender where id = ? and password = ?",id,password);
    }

    @Override
    public int updateUser(Long id, String email) {
        return jdbcTemplate.update(
                "update users set email = ? where userid = ?",email,id);
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
                        rs.getTimestamp("updatetime").toLocalDateTime().toLocalDate(),
                        rs.getString("email")
                        );
            }
        };
    }

    private RowMapper<CalResponseDto> calRowMapperV2(){
        return new RowMapper<CalResponseDto>() {
            @Override
            public CalResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Calender calender= new Calender(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("password"),
                        rs.getString("todo"),
                        rs.getTimestamp("updatetime").toLocalDateTime().toLocalDate(),
                         rs.getString("email"));
                 return new CalResponseDto(calender);
            }
        };
    }


}
