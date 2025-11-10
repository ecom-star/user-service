package com.ecommerce.user_service.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @Email @NotBlank String email
) {
}
