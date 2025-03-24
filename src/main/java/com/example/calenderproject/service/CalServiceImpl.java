package com.example.calenderproject.service;

import com.example.calenderproject.CalenderProjectApplication;
import com.example.calenderproject.domain.Calender;
import com.example.calenderproject.dto.CalRequestDto;
import com.example.calenderproject.dto.CalResponseDto;
import com.example.calenderproject.repository.CalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalServiceImpl implements CalService {

    private final CalRepository calRepository;

    public CalServiceImpl(CalRepository calRepository) {
        this.calRepository = calRepository;
    }

    @Override
    public CalResponseDto createCal(CalRequestDto dto) {

        Calender calender = new Calender(dto.getName(),
                dto.getToDo(), dto.getPassword());

        return calRepository.createCal(calender);
    }

    @Override
    public CalResponseDto findCalByID(Long id) {
        Optional<Calender> calender = calRepository.findCalByID(id);
        return new CalResponseDto(calender.orElseThrow());
    }

    @Override
    public List<CalResponseDto> findAllCal() {
        return calRepository.findAllCal();
    }
}
