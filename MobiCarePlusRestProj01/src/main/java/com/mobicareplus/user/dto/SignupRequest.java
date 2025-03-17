package com.mobicareplus.user.dto;

import com.mobicareplus.user.model.User.Role;
import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
    private Role role;
    private String name;
    private String contactNumber;
    private String address;
}