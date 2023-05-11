package com.psk.eshop.service;

import com.psk.eshop.dto.UserRequestDTO;
import com.psk.eshop.model.User;
import com.psk.eshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Override
    public User createUser(UserRequestDTO userRequest) {
        var newUser = User.builder()
                .userType(userRequest.getUserType())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phoneNo(userRequest.getPhoneNo())
                .address(userRequest.getAddress())
                .build();
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", userId))
        );
    }
    @Override
    public User updateUser(Long userId, UserRequestDTO userRequest) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUserType(userRequest.getUserType());
                    user.setName(userRequest.getName());
                    user.setEmail(userRequest.getEmail());
                    user.setPassword(userRequest.getPassword());
                    user.setPhoneNo(userRequest.getPhoneNo());
                    user.setAddress(userRequest.getAddress());
                    return userRepository.save(user);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", userId))
                );
    }
}
