package com.dev.leadBackEngineerTest.dto;

import com.dev.leadBackEngineerTest.domain.TicketStatus;

import java.util.UUID;

public class TicketDTO {

    private UUID Id;
    private String Description;
    private UUID UserId;
    private TicketStatus Status;

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

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public TicketStatus getStatus() {
        return Status;
    }

    public void setStatus(TicketStatus status) {
        Status = status;
    }
}
