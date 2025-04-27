package com.gildong.gildongE.repository;

import com.gildong.gildongE.model.Consumable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ConsumableRepository extends MongoRepository<Consumable, String> {
    List<Consumable> findByCarId(String carId);
    List<Consumable> findByCarIdOrderByCreatedAtDesc(String carId);
}