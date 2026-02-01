package com.ecommerceapirest.services;

import com.ecommerceapirest.dtos.user.UserRequestDTO;
import com.ecommerceapirest.dtos.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserRequestDTO dto);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Long id, UserRequestDTO dto);

    void deleteUser(Long id);
}
