package com.example.calenderproject.dto;

import com.example.calenderproject.domain.Calender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalResponseDto {

    private Long id;
    private String name;
    private Integer password;
    private String toDo;
    private LocalDate updateTime;
    private String email;


    public CalResponseDto(Calender calender){
        this.id = calender.getId();
        this.name = calender.getName();
        this.password = calender.getPassword();
        this.toDo = calender.getToDo();
        this.updateTime = calender.getUpdateTime();
        this.email = calender.getEmail();
    }


    public CalResponseDto(long id, String name, Integer password, String toDo, LocalDate updateTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.toDo = toDo;
        this.updateTime = updateTime;
    }


}
