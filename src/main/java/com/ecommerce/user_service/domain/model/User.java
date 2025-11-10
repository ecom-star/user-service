package com.ecommerce.user_service.domain.model;

import java.time.Instant;
import java.util.UUID;

public class User {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private Instant createdAt;

    public User() {}

    public User(UUID userId, String firstName, String lastName, String email, boolean active, Instant createdAt) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
