package com.dev.leadBackEngineerTest.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.UuidGenerator;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID Id;

    @NotBlank
    @Size(max = 500)
    private String Description;

    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    @PrePersist
    protected void onCreate() {
        CreatedAt = UpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        UpdatedAt = LocalDateTime.now();
    }
}
