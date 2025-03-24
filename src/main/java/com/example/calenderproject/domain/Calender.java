package com.example.calenderproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Calender {
    private Long id;
    private String name;
    private Integer password;
    private String toDo;
    private LocalDate updateTime;

    public Calender(String name,String toDo,Integer password){
        this.name = name;
        this.toDo = toDo;
        this.password = password;
    }

    public Calender(String name,String toDo,Integer password,LocalDate updateTime){
        this.name = name;
        this.toDo = toDo;
        this.password = password;
        this.updateTime = updateTime;
    }

    public void update(String name,String toDo){
        this.name = name;
        this.toDo = toDo;
    }



}
