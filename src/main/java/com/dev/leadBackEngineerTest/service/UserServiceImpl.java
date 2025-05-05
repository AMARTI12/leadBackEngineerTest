package com.dev.leadBackEngineerTest.service;

import com.dev.leadBackEngineerTest.domain.User;
import com.dev.leadBackEngineerTest.dto.UserDTO;
import com.dev.leadBackEngineerTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(u -> {
                    UserDTO dto = new UserDTO();
                    dto.setId(u.getId());
                    dto.setFirstName(u.getFirstName());
                    dto.setLastName(u.getLastName());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
