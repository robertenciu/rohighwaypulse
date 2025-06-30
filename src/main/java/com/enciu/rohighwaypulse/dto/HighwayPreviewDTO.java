package com.enciu.rohighwaypulse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighwayPreviewDTO {
    String name;
    Float length;
    String startCity;
    String endCity;
}
