package com.dev.leadBackEngineerTest.service;

import com.dev.leadBackEngineerTest.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UUID id, UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(UUID id);
}
