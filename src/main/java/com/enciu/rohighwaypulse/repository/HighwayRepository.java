package com.enciu.rohighwaypulse.repository;

import com.enciu.rohighwaypulse.module.Highway;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighwayRepository extends MongoRepository<Highway, String> {
    Highway findByNameIgnoreCase(String name);
}
