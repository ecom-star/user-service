package com.ecommerce.user_service.application.service;

import com.ecommerce.user_service.application.port.in.UserUseCase;
import com.ecommerce.user_service.application.port.out.UserRepositoryPort;
import com.ecommerce.user_service.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Slf4j
public class UserService implements UserUseCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User create(User user) {
        log.info("Creating new user: {}", user.getEmail());
        if (userRepositoryPort.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        user.setUserId(UUID.randomUUID());
        user.setActive(true);
        user.setCreatedAt(Instant.now());
        return userRepositoryPort.save(user);
    }

    @Override
    public User update(UUID id, User user) {
        log.info("Updating user {}", id);
        User existing = userRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (Objects.nonNull(user.getFirstName())) existing.setFirstName(user.getFirstName());
        if (Objects.nonNull(user.getLastName()))  existing.setLastName(user.getLastName());
        if (Objects.nonNull(user.getEmail()))      existing.setEmail(user.getEmail());

        return userRepositoryPort.save(existing);
    }

    @Override
    public User getById(UUID id) {
        log.info("Fetching user {}", id);
        return userRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public Page<User> list(Pageable pageable) {
        log.info("Listing all users");
        return userRepositoryPort.findAll(pageable);
    }
}
