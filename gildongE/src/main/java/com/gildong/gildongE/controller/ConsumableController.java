package com.gildong.gildongE.controller;

import com.gildong.gildongE.model.Consumable;
import com.gildong.gildongE.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consumables")
public class ConsumableController {

    @Autowired
    private ConsumableService consumableService;

    @PostMapping
    public ResponseEntity<Consumable> saveConsumable(@RequestBody Consumable consumable) {
        return ResponseEntity.ok(consumableService.saveConsumable(consumable));
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<Consumable>> getConsumablesForCar(@PathVariable String carId) {
        return ResponseEntity.ok(consumableService.getLatestConsumablesForCar(carId));
    }

    @GetMapping("/car/{carId}/drowsiness")
    public ResponseEntity<Boolean> checkDrowsiness(@PathVariable String carId) {
        boolean isDrowsy = consumableService.detectDrowsiness(carId);
        return ResponseEntity.ok(isDrowsy);
    }
}