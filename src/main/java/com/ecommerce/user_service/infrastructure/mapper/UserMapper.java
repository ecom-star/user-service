package com.ecommerce.user_service.infrastructure.mapper;

import com.ecommerce.user_service.domain.model.User;
import com.ecommerce.user_service.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity e) {
        User user = new User();
        user.setUserId(e.getUserId());
        user.setFirstName(e.getFirstName());
        user.setLastName(e.getLastName());
        user.setEmail(e.getEmail());
        user.setActive(e.isActive());
        user.setCreatedAt(e.getCreatedAt());
        return user;
    }

    public UserEntity toEntity(User d) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(d.getUserId());
        userEntity.setFirstName(d.getFirstName());
        userEntity.setLastName(d.getLastName());
        userEntity.setEmail(d.getEmail());
        userEntity.setActive(d.isActive());
        userEntity.setCreatedAt(d.getCreatedAt());

        return userEntity;
    }
}
