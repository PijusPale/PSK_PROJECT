package com.psk.eshop.dto;

import com.psk.eshop.enums.UserType;
import lombok.Getter;

@Getter
public class UserRequestDTO {
    private UserType userType;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
}
