package com.enciu.rohighwaypulse.service;

import com.enciu.rohighwaypulse.module.Highway;
import com.enciu.rohighwaypulse.repository.HighwayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighwayServiceImpl implements HighwayService {
    @Autowired
    private HighwayRepository highwayRepository;
    public List<Highway> getAllHighways() {
        return highwayRepository.findAll();
    }
}
