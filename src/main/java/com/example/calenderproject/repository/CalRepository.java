package com.example.calenderproject.repository;

import com.example.calenderproject.domain.Calender;
import com.example.calenderproject.dto.CalRequestDto;
import com.example.calenderproject.dto.CalResponseDto;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Optional;

public interface CalRepository {

    CalResponseDto createCal(Calender calender);

    Optional<Calender> findCalByID(Long id);

    List<CalResponseDto> findAllCal();

    int updateCal(Long id, Integer password,String name,String toDo);

    int deleteCal(Long id, Integer password);

    int updateUser(Long id, String email);
}
