package com.enciu.rohighwaypulse.controller;

import com.enciu.rohighwaypulse.dto.HighwayPreviewDTO;
import com.enciu.rohighwaypulse.dto.HighwayScheduleDTO;
import com.enciu.rohighwaypulse.module.Highway;
import com.enciu.rohighwaypulse.service.HighwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/highways")
@CrossOrigin
public class HighwayController {
    @Autowired
    private HighwayService highwayService;
    @GetMapping()
    public ResponseEntity<List<HighwayPreviewDTO>> getHighwayPreviews() {
        return new ResponseEntity<>(highwayService.getHighwaysPreviews(), HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<Highway> getHighwayByName(@PathVariable String name) {
        return new ResponseEntity<>(highwayService.getHighway(name), HttpStatus.OK);
    }
    @GetMapping("/schedule")
    public ResponseEntity<Map<Integer, List<HighwayScheduleDTO>>> getHighwaySchedule() {
        return new ResponseEntity<>(highwayService.fetchCalendar(), HttpStatus.OK);
    }

}
