package com.psk.eshop.service;

import com.psk.eshop.dto.UserRequestDTO;
import com.psk.eshop.model.User;

import java.util.List;

public interface UserService {
    User createUser(UserRequestDTO user);
    List<User> getUsers();
    User getUserById(Long userId);
    User updateUser(Long userId, UserRequestDTO userRequest);
    void deleteUserById(Long userId);
}
