package com.dev.leadBackEngineerTest.dto;

public class AuthRespDTO {
    private String token;
    public AuthRespDTO(String token) { this.token = token; }
    public String getToken() { return token; }
}
