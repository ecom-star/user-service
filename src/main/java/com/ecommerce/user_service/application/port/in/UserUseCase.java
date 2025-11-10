package com.ecommerce.user_service.application.port.in;

import com.ecommerce.user_service.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserUseCase {
    User create(User user);
    User update(UUID id, User user);
    User getById(UUID id);
    Page<User> list(Pageable pageable);
}
