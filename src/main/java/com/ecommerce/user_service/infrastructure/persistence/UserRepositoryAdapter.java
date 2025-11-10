package com.ecommerce.user_service.infrastructure.persistence;

import com.ecommerce.user_service.application.port.out.UserRepositoryPort;

import com.ecommerce.user_service.domain.model.User;
import com.ecommerce.user_service.infrastructure.mapper.UserMapper;
import com.ecommerce.user_service.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userRepo;
    private final UserMapper mapper;

    @Override
    public User save(User user) {
        UserEntity saved = userRepo.save(mapper.toEntity(user));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepo.findById(id).map(mapper::toDomain);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable).map(mapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
