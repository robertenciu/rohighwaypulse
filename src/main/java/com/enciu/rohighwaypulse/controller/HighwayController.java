package com.enciu.rohighwaypulse.controller;

import com.enciu.rohighwaypulse.module.Highway;
import com.enciu.rohighwaypulse.service.HighwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/highways")
@CrossOrigin
public class HighwayController {
    @Autowired
    private HighwayService highwayService;
    @GetMapping()
    public ResponseEntity<List<Highway>> getAllHighways() {
        return new ResponseEntity<>(highwayService.getAllHighways(), HttpStatus.OK);
    }
}
