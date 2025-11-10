package com.ecommerce.user_service.infrastructure.dto;

import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        boolean active,
        Instant createdAt
) {
}
