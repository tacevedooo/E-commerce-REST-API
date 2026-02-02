package com.ecommerceapirest.mappers;

import com.ecommerceapirest.dtos.user.UserRequestDTO;
import com.ecommerceapirest.dtos.user.UserResponseDTO;
import com.ecommerceapirest.models.User;

public class UserMapper {

    // DTO → Entity
    public static User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    // Entity → DTO
    public static UserResponseDTO toResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
