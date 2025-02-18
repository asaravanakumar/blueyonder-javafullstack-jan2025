package com.examples.sboot.jwt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginRequest {
    private final String email;
    private final String password;
    private final String role;
}
