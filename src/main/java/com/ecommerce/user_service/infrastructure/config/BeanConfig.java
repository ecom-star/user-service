package com.ecommerce.user_service.infrastructure.config;

import com.ecommerce.user_service.application.port.in.UserUseCase;
import com.ecommerce.user_service.application.port.out.UserRepositoryPort;
import com.ecommerce.user_service.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserUseCase userUseCase(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }
}
