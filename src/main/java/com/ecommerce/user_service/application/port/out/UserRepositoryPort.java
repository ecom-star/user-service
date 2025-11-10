package com.ecommerce.user_service.application.port.out;

import com.ecommerce.user_service.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(UUID id);
    Page<User> findAll(Pageable pageable);
    boolean existsByEmail(String email);
}
