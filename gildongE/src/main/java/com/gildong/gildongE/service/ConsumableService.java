package com.gildong.gildongE.service;

import com.gildong.gildongE.dto.ConsumableRequest;
import com.gildong.gildongE.dto.ConsumableResponse;
import com.gildong.gildongE.model.Consumable;
import com.gildong.gildongE.repository.ConsumableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumableService {

    @Autowired
    private ConsumableRepository consumableRepository;

    public ConsumableResponse saveConsumable(ConsumableRequest req) {
        // 1) DTO → Entity
        Consumable entity = new Consumable();
        entity.setCarId(req.getCarId());
        entity.setSpeed(req.getSpeed());
        entity.setEngineRpm(req.getEngineRpm());
        entity.setThrottlePosition(req.getThrottlePosition());
        entity.setEngineLoad(req.getEngineLoad());
        entity.setFuelTankLevel(req.getFuelTankLevel());
        entity.setCoolantTemp(req.getCoolantTemp());
        entity.setElectricalSystem(req.getElectricalSystem());
        entity.setProblemDetected(req.isProblemDetected());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        // 2) 저장
        Consumable saved = consumableRepository.save(entity);

        // 3) Entity → DTO
        return toResponse(saved);
    }

    public List<ConsumableResponse> getLatestConsumablesForCar(String carId) {
        return consumableRepository
                .findByCarIdOrderByCreatedAtDesc(carId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ConsumableResponse toResponse(Consumable e) {
        ConsumableResponse dto = new ConsumableResponse();
        dto.setId(e.getId());
        dto.setCarId(e.getCarId());
        dto.setSpeed(e.getSpeed());
        dto.setEngineRpm(e.getEngineRpm());
        dto.setThrottlePosition(e.getThrottlePosition());
        dto.setEngineLoad(e.getEngineLoad());
        dto.setFuelTankLevel(e.getFuelTankLevel());
        dto.setCoolantTemp(e.getCoolantTemp());
        dto.setElectricalSystem(e.getElectricalSystem());
        dto.setProblemDetected(e.isProblemDetected());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setUpdatedAt(e.getUpdatedAt());
        return dto;
    }
}
