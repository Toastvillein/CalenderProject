package com.example.calenderproject.service;

import com.example.calenderproject.dto.CalRequestDto;
import com.example.calenderproject.dto.CalResponseDto;

import java.util.List;

public interface CalService {

    CalResponseDto createCal(CalRequestDto dto);

    CalResponseDto findCalByID(Long id);

    List<CalResponseDto> findAllCal();

    CalResponseDto updateCal(Long id,Integer password,String name,String toDo);

    void deleteCal(Long id, Integer password);

    CalResponseDto updateUser(Long id,Integer password ,String email);

}
