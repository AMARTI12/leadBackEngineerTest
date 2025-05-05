package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.dto.UserDTO;
import com.dev.leadBackEngineerTest.helpers.TestSecurityConfig;
import com.dev.leadBackEngineerTest.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestSecurityConfig.class)
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    private UUID testUserId;

    @BeforeEach
    void setUp() {
        // Creamos un usuario real antes de cada prueba para verificarla en los otos metodos
        UserDTO user = new UserDTO(null, "Fredy", "Martínez");
        UserDTO createdUser = userService.createUser(user);
        testUserId = createdUser.getId();
    }

    @Test
    void shouldGetAllUsers() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void shouldGetUserById() throws Exception {
        mockMvc.perform(get("/usuarios/{id}", testUserId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Fredy"))
                .andExpect(jsonPath("$.lastName").value("Martínez"));
    }

    @Test
    void shouldCreateUser() throws Exception {
        UserDTO newUser = new UserDTO(null, "Ana", "García");
        String json = objectMapper.writeValueAsString(newUser);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Ana"))
                .andExpect(jsonPath("$.lastName").value("García"));
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UserDTO updatedUser = new UserDTO(testUserId, "Fredy Alexander", "Martínez Mora");
        String json = objectMapper.writeValueAsString(updatedUser);

        mockMvc.perform(put("/usuarios/{id}", testUserId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Fredy Alexander"))
                .andExpect(jsonPath("$.lastName").value("Martínez Mora"));
    }

    @Test
    void shouldReturnNotFoundForNonExistentUser() throws Exception {
        UUID nonExistentId = UUID.randomUUID();

        mockMvc.perform(get("/usuarios/{id}", nonExistentId))
                .andExpect(status().isNotFound());
    }
}
