package com.examples.sboot.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Security with JWT";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return "Hello!!!";
    }
}
