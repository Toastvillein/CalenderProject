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
    private int password;
    private String toDo;
    private LocalDate updateTime;

    public Calender(String name,String toDo,int password){
        this.name = name;
        this.toDo = toDo;
        this.password = password;
    }

    public Calender(String name,String toDo,int password,LocalDate updateTime){
        this.name = name;
        this.toDo = toDo;
        this.password = password;
        this.updateTime = updateTime;
    }



}
