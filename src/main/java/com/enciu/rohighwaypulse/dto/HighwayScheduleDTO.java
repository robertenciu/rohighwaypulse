package com.enciu.rohighwaypulse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighwayScheduleDTO {
    private String segment;
    private double lengthKm;
    private Integer year;
}
