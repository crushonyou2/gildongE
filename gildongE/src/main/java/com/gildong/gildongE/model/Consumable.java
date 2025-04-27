package com.gildong.gildongE.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "consumables")
public class Consumable {
    @Id
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
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}