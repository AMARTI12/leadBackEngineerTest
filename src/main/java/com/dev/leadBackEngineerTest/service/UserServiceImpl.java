package com.dev.leadBackEngineerTest.service;

import com.dev.leadBackEngineerTest.domain.User;
import com.dev.leadBackEngineerTest.dto.UserDTO;
import com.dev.leadBackEngineerTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
}
