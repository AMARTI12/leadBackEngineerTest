package com.dev.leadBackEngineerTest.dto;

import com.dev.leadBackEngineerTest.domain.TicketStatus;

import java.util.UUID;

public class TicketDTO {

    private UUID id;
    private String description;
    private UUID userId;
    private TicketStatus status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
