package com.ecommerce.user_service.infrastructure.controller;

import com.ecommerce.user_service.application.port.in.UserUseCase;
import com.ecommerce.user_service.domain.model.User;
import com.ecommerce.user_service.infrastructure.dto.PageResponse;
import com.ecommerce.user_service.infrastructure.dto.UserRequest;
import com.ecommerce.user_service.infrastructure.dto.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public UserResponse create(@Valid @RequestBody UserRequest req) {
        User user = new User();
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setEmail(req.email());
        User saved = userUseCase.create(user);
        return toResponse(saved);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable UUID id, @RequestBody UserRequest req) {
        User user = new User();
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setEmail(req.email());
        return toResponse(userUseCase.update(id, user));
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable UUID id) {
        return toResponse(userUseCase.getById(id));
    }

    @GetMapping
    public PageResponse<UserResponse> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<User> users = userUseCase.list(PageRequest.of(page, size));
        return new PageResponse<>(
                users.map(this::toResponse).getContent(),
                users.getNumber(),
                users.getSize(),
                users.getTotalElements(),
                users.getTotalPages()
        );
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isActive(),
                user.getCreatedAt()
        );
    }
}
