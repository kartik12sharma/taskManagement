package com.example.taskmanagement.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class jwtToken {
    String email;
    Date createdAt;
    private Long userId;
    Date expiryAt;
    List<Role> roles;
}
