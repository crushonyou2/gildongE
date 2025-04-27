package com.gildong.gildongE.service;

import com.gildong.gildongE.model.Car;
import com.gildong.gildongE.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car registerCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getCarsByUserId(String userId) {
        return carRepository.findByUserId(userId);
    }
}