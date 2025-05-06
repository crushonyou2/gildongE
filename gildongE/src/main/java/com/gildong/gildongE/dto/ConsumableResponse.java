package com.gildong.gildongE.dto;

import java.time.LocalDateTime;

public class ConsumableResponse {
    private String id;
    private String carId;
    private float speed;
    private float engineRpm;
    private float throttlePosition;
    private float engineLoad;
    private float fuelTankLevel;
    private float coolantTemp;
    private String electricalSystem;
    private boolean problemDetected;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ConsumableResponse() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getEngineRpm() {
        return engineRpm;
    }
    public void setEngineRpm(float engineRpm) {
        this.engineRpm = engineRpm;
    }

    public float getThrottlePosition() {
        return throttlePosition;
    }
    public void setThrottlePosition(float throttlePosition) {
        this.throttlePosition = throttlePosition;
    }

    public float getEngineLoad() {
        return engineLoad;
    }
    public void setEngineLoad(float engineLoad) {
        this.engineLoad = engineLoad;
    }

    public float getFuelTankLevel() {
        return fuelTankLevel;
    }
    public void setFuelTankLevel(float fuelTankLevel) {
        this.fuelTankLevel = fuelTankLevel;
    }

    public float getCoolantTemp() {
        return coolantTemp;
    }
    public void setCoolantTemp(float coolantTemp) {
        this.coolantTemp = coolantTemp;
    }

    public String getElectricalSystem() {
        return electricalSystem;
    }
    public void setElectricalSystem(String electricalSystem) {
        this.electricalSystem = electricalSystem;
    }

    public boolean isProblemDetected() {
        return problemDetected;
    }
    public void setProblemDetected(boolean problemDetected) {
        this.problemDetected = problemDetected;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
