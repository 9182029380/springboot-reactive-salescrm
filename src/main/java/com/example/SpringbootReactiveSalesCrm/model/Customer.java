package com.example.SpringbootReactiveSalesCrm.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String customerName;
    private String email;
    private String phone;
    private String company;
    private String industry;
    private String leadSource;
    private String leadStatus;
    private String assignedTo;
    private String salesStage;
    private Double dealValue;
    private LocalDateTime nextFollowUp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
}

