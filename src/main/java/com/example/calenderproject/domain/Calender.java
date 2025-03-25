package com.example.calenderproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Calender {
    private Long id;
    private String name;
    private Integer password;
    private String toDo;
    private LocalDate updateTime;
    private String email;


    public Calender(String name,String toDo,Integer password){
        this.name = name;
        this.toDo = toDo;
        this.password = password;
    }

    public Calender(Long id, String name,Integer password,String toDo,LocalDate updateTime){
        this.id = id;
        this.name = name;
        this.password = password;
        this.toDo = toDo;
        this.updateTime = updateTime;
    }

    public void update(String name,String toDo){
        this.name = name;
        this.toDo = toDo;
    }







}
