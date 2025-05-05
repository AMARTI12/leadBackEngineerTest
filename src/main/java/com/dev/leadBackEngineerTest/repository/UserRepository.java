package com.dev.leadBackEngineerTest.repository;

import com.dev.leadBackEngineerTest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
