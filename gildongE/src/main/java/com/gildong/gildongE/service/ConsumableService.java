package com.gildong.gildongE.service;

import com.gildong.gildongE.model.Consumable;
import com.gildong.gildongE.repository.ConsumableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsumableService {

    @Autowired
    private ConsumableRepository consumableRepository;

    public Consumable saveConsumable(Consumable consumable) {
        consumable.setCreatedAt(LocalDateTime.now());
        consumable.setUpdatedAt(LocalDateTime.now());
        return consumableRepository.save(consumable);
    }

    public List<Consumable> getLatestConsumablesForCar(String carId) {
        return consumableRepository.findByCarIdOrderByCreatedAtDesc(carId);
    }

    // 졸음 감지 로직 (예시)
    public boolean detectDrowsiness(String carId) {
        // 여기에 졸음 감지 로직 구현
        return false;
    }
}