package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.user.UserRequestDTO;
import com.ecommerceapirest.dtos.user.UserResponseDTO;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    UserResponseDTO getUserById(@NotNull Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(@NotNull Long id, UserRequestDTO dto);

    void deleteUser(@NotNull Long id);
}
