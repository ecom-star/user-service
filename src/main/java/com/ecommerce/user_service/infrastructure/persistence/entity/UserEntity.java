package com.ecommerce.user_service.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "user_id", columnDefinition = "uuid")
    private UUID userId;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private boolean active;

    @Column(nullable = false)
    private Instant createdAt;
}
