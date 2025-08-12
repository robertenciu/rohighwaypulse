package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.dto.HighwayPreviewDTO;
import com.enciu.rohighwaypulse.dto.HighwayScheduleDTO;
import com.enciu.rohighwaypulse.module.Highway;

import java.util.List;
import java.util.Map;

public interface HighwayService {
    List<HighwayPreviewDTO> getHighwaysPreviews();
    Highway getHighway(String name);
    Map<Integer, List<HighwayScheduleDTO>> fetchCalendar();
}
