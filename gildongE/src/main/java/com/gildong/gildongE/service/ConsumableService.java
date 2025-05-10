package com.gildong.gildongE.service;

import com.gildong.gildongE.dto.ConsumableRequest;
import com.gildong.gildongE.dto.ConsumableResponse;
import com.gildong.gildongE.exception.ResourceNotFoundException;
import com.gildong.gildongE.model.Consumable;
import com.gildong.gildongE.repository.ConsumableRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumableService {
    private final ConsumableRepository consumableRepo;
    private final UserService userService;

    public ConsumableService(ConsumableRepository consumableRepo,
                             UserService userService) {
        this.consumableRepo = consumableRepo;
        this.userService    = userService;
    }

    /** 소모품(차량 교체 날짜) 정보 저장 */
    public ConsumableResponse saveConsumable(ConsumableRequest req) {
        // 존재 여부 검증
        userService.getUserById(req.getUserId());

        Consumable e = new Consumable();
        e.setUserId(req.getUserId());
        e.setCarModel(req.getCarModel());
        e.setCarNumber(req.getCarNumber());
        e.setEngineOilDate(req.getEngineOilDate());
        e.setBatteryDate(req.getBatteryDate());
        e.setCoolantDate(req.getCoolantDate());
        e.setTransmissionOilDate(req.getTransmissionOilDate());
        e.setBrakeOilDate(req.getBrakeOilDate());
        e.setAirconFilterDate(req.getAirconFilterDate());
        e.setCreatedAt(LocalDateTime.now());
        e.setUpdatedAt(LocalDateTime.now());
        Consumable saved = consumableRepo.save(e);

        return toResponse(saved);
    }

    /** 사용자별 소모품 내역 조회 */
    public List<ConsumableResponse> listConsumables(String userId) {
        // 존재 여부 검증
        userService.getUserById(userId);

        return consumableRepo.findByUserId(userId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ConsumableResponse toResponse(Consumable e) {
        ConsumableResponse dto = new ConsumableResponse();
        dto.setId(e.getId());
        dto.setUserId(e.getUserId());
        dto.setCarModel(e.getCarModel());
        dto.setCarNumber(e.getCarNumber());
        dto.setEngineOilDate(e.getEngineOilDate());
        dto.setBatteryDate(e.getBatteryDate());
        dto.setCoolantDate(e.getCoolantDate());
        dto.setTransmissionOilDate(e.getTransmissionOilDate());
        dto.setBrakeOilDate(e.getBrakeOilDate());
        dto.setAirconFilterDate(e.getAirconFilterDate());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setUpdatedAt(e.getUpdatedAt());
        return dto;
    }
}
