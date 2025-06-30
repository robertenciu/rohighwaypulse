package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.dto.HighwayPreviewDTO;
import com.enciu.rohighwaypulse.module.Highway;
import com.enciu.rohighwaypulse.repository.HighwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighwayServiceImpl implements HighwayService {
    @Autowired
    private HighwayRepository highwayRepository;

    public List<HighwayPreviewDTO> getHighwaysPreviews() {
        List<Highway> highways = highwayRepository.findAll();
        return highways
                .stream()
                .map(highway -> new HighwayPreviewDTO(
                        highway.getName(),
                        highway.getLength(),
                        highway.getStartCity(),
                        highway.getEndCity()))
                .toList();
    }

    @Override
    public Highway getHighway(String name) {
        return highwayRepository.findByNameIgnoreCase(name);
    }
}
