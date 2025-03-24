package com.example.calenderproject.controller;

import com.example.calenderproject.dto.CalRequestDto;
import com.example.calenderproject.dto.CalResponseDto;
import com.example.calenderproject.service.CalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calenders")
public class CalController {

    private final CalService calService;

    public CalController(CalService calService) {
        this.calService = calService;
    }

    @PostMapping
    public ResponseEntity<CalResponseDto> createCal(@RequestBody CalRequestDto dto){
        return new ResponseEntity<>(calService.createCal(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalResponseDto> findCalByID(@PathVariable Long id){
        return new ResponseEntity<>(calService.findCalByID(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CalResponseDto>> findAllCal(){
        return new ResponseEntity<>(calService.findAllCal(),HttpStatus.OK);
    }

    @PutMapping("/{id}/{password}")
    public ResponseEntity<CalResponseDto> updateCal(
            @PathVariable Long id,
            @PathVariable Integer password,
            @RequestBody CalRequestDto dto
    ){
        return new ResponseEntity<>(calService.updateCal(id,password,dto.getName(),dto.getToDo()),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{password}")
    public ResponseEntity<CalResponseDto> deleteCal(
            @PathVariable Long id,
            @PathVariable Integer password
    ){
        calService.deleteCal(id,password);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
