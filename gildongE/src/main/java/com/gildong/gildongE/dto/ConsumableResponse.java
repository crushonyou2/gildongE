package com.gildong.gildongE.dto;

import java.time.LocalDateTime;

public class ConsumableResponse {
    private String id;
    private String userId;
    private String carModel;
    private String carNumber;
    private String engineOilDate;
    private String batteryDate;
    private String coolantDate;
    private String transmissionOilDate;
    private String brakeOilDate;
    private String airconFilterDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getEngineOilDate() {
        return engineOilDate;
    }

    public void setEngineOilDate(String engineOilDate) {
        this.engineOilDate = engineOilDate;
    }

    public String getBatteryDate() {
        return batteryDate;
    }

    public void setBatteryDate(String batteryDate) {
        this.batteryDate = batteryDate;
    }

    public String getCoolantDate() {
        return coolantDate;
    }

    public void setCoolantDate(String coolantDate) {
        this.coolantDate = coolantDate;
    }

    public String getTransmissionOilDate() {
        return transmissionOilDate;
    }

    public void setTransmissionOilDate(String transmissionOilDate) {
        this.transmissionOilDate = transmissionOilDate;
    }

    public String getBrakeOilDate() {
        return brakeOilDate;
    }

    public void setBrakeOilDate(String brakeOilDate) {
        this.brakeOilDate = brakeOilDate;
    }

    public String getAirconFilterDate() {
        return airconFilterDate;
    }

    public void setAirconFilterDate(String airconFilterDate) {
        this.airconFilterDate = airconFilterDate;
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
