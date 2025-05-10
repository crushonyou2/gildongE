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
    private String userId;
    private String carModel;
    private String carNumber;
    private String engineOilDate;
    private String batteryDate;
    private String coolantDate;
    private String transmissionOilDate;
    private String brakeOilDate;
    private String airconFilterDate;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}