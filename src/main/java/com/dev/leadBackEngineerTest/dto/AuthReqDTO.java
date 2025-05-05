package com.dev.leadBackEngineerTest.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthReqDTO {

    @NotBlank(message = "El usuario no puede estar vacio")
    private String username;

    @NotBlank(message = "La contrseña no puede estar vacia")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
