package com.example.calenderproject.dto;

import com.example.calenderproject.domain.Calender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CalResponseDto {

    private Long id;
    private String name;
    private Integer password;
    private String toDo;
    private LocalDate updateTime;

    public CalResponseDto(Calender calender){
        this.id = calender.getId();
        this.name = calender.getName();
        this.password = calender.getPassword();
        this.toDo = calender.getToDo();
        this.updateTime = calender.getUpdateTime();
    }


}
