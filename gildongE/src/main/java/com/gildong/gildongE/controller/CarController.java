package com.gildong.gildongE.controller;

import com.gildong.gildongE.model.Car;
import com.gildong.gildongE.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Car> registerCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.registerCar(car));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(carService.getCarsByUserId(userId));
    }
}