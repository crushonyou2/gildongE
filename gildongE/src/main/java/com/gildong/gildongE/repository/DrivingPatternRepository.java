package com.gildong.gildongE.repository;

import com.gildong.gildongE.model.DrivingPattern;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DrivingPatternRepository extends MongoRepository<DrivingPattern, String> {
    List<DrivingPattern> findByUserId(String userId);
}
