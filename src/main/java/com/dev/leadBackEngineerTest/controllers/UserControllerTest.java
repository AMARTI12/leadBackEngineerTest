package com.dev.leadBackEngineerTest.controllers;

import com.dev.leadBackEngineerTest.dto.UserDTO;
import com.dev.leadBackEngineerTest.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UserDTO testUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        testUser = new UserDTO(
                UUID.randomUUID(),
                "Fredy Alexander",
                "Martínez Mora"
        );
    }

    @Test
    public void testCreateUser() {
        when(userService.createUser(any(UserDTO.class))).thenReturn(testUser);

        UserDTO createdUser = userController.createUser(testUser);

        assertNotNull(createdUser);
        assertEquals("Fredy Alexander", createdUser.getFirstName());
        assertEquals("Martínez Mora", createdUser.getLastName());
        verify(userService, times(1)).createUser(any(UserDTO.class));
    }

    @Test
    public void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(testUser));

        List<UserDTO> users = userController.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("Fredy Alexander", users.get(0).getFirstName());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        UUID id = testUser.getId();
        when(userService.getUserById(id)).thenReturn(testUser);

        UserDTO user = userController.getUserById(id);

        assertNotNull(user);
        assertEquals(id, user.getId());
        verify(userService, times(1)).getUserById(id);
    }
}