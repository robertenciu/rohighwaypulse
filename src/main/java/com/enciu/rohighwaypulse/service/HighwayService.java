package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.dto.HighwayPreviewDTO;
import com.enciu.rohighwaypulse.module.Highway;

import java.util.List;

public interface HighwayService {
    List<HighwayPreviewDTO> getHighwaysPreviews();
    Highway getHighway(String name);
}
