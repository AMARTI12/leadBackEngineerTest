package com.dev.leadBackEngineerTest.dto;

import com.dev.leadBackEngineerTest.domain.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class TicketDTO {

    private UUID id;

    @NotBlank(message = "La descripción del ticket no puede estar vacia")
    @Size(max = 500)
    private String description;

    @NotNull(message = "Debe asociar un usuario valido para este ticket")
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
