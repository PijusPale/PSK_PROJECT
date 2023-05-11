package com.psk.eshop.controller;

import com.psk.eshop.dto.UserRequestDTO;
import com.psk.eshop.model.User;
import com.psk.eshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String add(@RequestBody UserRequestDTO user){
        userService.createUser(user);
        return "new user is added!";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User update(@PathVariable Long userId, @RequestBody UserRequestDTO userRequest){
        return userService.updateUser(userId, userRequest);
    }
}
