package com.gildong.gildongE.dto;

public class ConsumableRequest {
    private String userId;
    private String carModel;
    private String carNumber;
    private String engineOilDate;
    private String batteryDate;
    private String coolantDate;
    private String transmissionOilDate;
    private String brakeOilDate;
    private String airconFilterDate;

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
}
