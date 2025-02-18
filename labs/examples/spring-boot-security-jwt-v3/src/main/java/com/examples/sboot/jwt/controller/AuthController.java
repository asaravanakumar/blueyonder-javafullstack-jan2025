package com.examples.sboot.jwt.controller;

import com.examples.sboot.jwt.model.LoginRequest;
import com.examples.sboot.jwt.model.LoginResponse;
import com.examples.sboot.jwt.security.JwtIssuer;
import com.examples.sboot.jwt.security.UserPrincipal;
import com.examples.sboot.jwt.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
//    private final JwtIssuer jwtIssuer;
//
//    private final AuthenticationManager authenticationManager;

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        log.info("Received Login Request {}", request);

//        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        var principal = (UserPrincipal) authentication.getPrincipal();
//
//        var roles = principal.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .toList();
//
//        log.info("User Authentication Success. UserId: {}, Email: {}, Roles: {}", principal.getUserId(), principal.getEmail(), roles);
//
//        var token = jwtIssuer.issue(JwtIssuer.Request.builder().userId(principal.getUserId()).email(principal.getEmail()).roles(roles).build());
//        LoginResponse response = LoginResponse.builder().token(token).build();
//        log.info("Issuing JWT Token {}", token);

//        return  response;

        return authService.attemptLogin(request.getEmail(), request.getPassword());

    }

    // http://localhost:7071/auth/login => JWT Token
}
