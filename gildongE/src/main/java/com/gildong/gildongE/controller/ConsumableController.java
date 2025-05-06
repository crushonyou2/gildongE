package com.gildong.gildongE.controller;

import com.gildong.gildongE.dto.ConsumableRequest;
import com.gildong.gildongE.dto.ConsumableResponse;
import com.gildong.gildongE.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumables")
public class ConsumableController {

    @Autowired
    private ConsumableService consumableService;

    @PostMapping
    public ResponseEntity<ConsumableResponse> create(@RequestBody ConsumableRequest request) {
        ConsumableResponse resp = consumableService.saveConsumable(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ConsumableResponse>> listByCar(@PathVariable String carId) {
        List<ConsumableResponse> list = consumableService.getLatestConsumablesForCar(carId);
        return ResponseEntity.ok(list);
    }
}
