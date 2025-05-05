package com.dev.leadBackEngineerTest.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @NotNull
    @ManyToOne
    private User user;

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

    public Ticket(UUID id, String description, TicketStatus status, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        Id = id;
        Description = description;
        this.status = status;
        this.user = user;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
}
