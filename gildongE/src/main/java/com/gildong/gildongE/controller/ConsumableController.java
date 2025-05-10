package com.gildong.gildongE.controller;

import com.gildong.gildongE.dto.ConsumableRequest;
import com.gildong.gildongE.dto.ConsumableResponse;
import com.gildong.gildongE.service.ConsumableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumables")
public class ConsumableController {
    private final ConsumableService consumableService;

    public ConsumableController(ConsumableService consumableService) {
        this.consumableService = consumableService;
    }

    /** 소모품(교체일) 정보 저장 */
    @PostMapping
    public ResponseEntity<ConsumableResponse> save(
            @RequestBody ConsumableRequest req) {
        ConsumableResponse resp = consumableService.saveConsumable(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    /** 사용자별 소모품 내역 조회 */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ConsumableResponse>> listByUser(
            @PathVariable String userId) {
        List<ConsumableResponse> list = consumableService.listConsumables(userId);
        return ResponseEntity.ok(list);
    }
}
