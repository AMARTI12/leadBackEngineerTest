package com.dev.leadBackEngineerTest.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    @NotBlank(message = "Los nombres no pueden estar vacíos")
    private String firstName;
    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    private String lastName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
