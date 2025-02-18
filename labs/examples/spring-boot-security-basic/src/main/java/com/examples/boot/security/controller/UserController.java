package com.examples.boot.security.controller;

import java.security.Principal;
import java.util.List;

import com.sun.security.auth.UserPrincipal;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.repo.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;	

	@RequestMapping("/")
	@CrossOrigin("*")
	public String greetings() {
		return "Hey! Welcome to Spring Security Training";
	}
	
	@PostMapping("/register")
	@CrossOrigin("*")
	public ResponseEntity<String> register(@RequestBody UserAccount user) {
		userRepository.save(new UserAccount(user.getUsername(),encoder.encode(user.getPassword()),user.getRole(),true));
		return ResponseEntity.ok().body("{\"status\": \"Success\", \"message\": \"Registration Successful\"}");
	}	
	
	@RequestMapping("/users")
	@CrossOrigin("*")
	public List<UserAccount> listUsers() {
		return userRepository.findAll();
	}	

	@RequestMapping("/authenticate")
	@CrossOrigin("*")
	public Principal authenticate(Principal user) {
		return user;
	}

//	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/user")
	@CrossOrigin("*")
	public Principal user(Principal user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("/manager")
	@CrossOrigin("*")
	public Principal manager(Principal user) {
		System.out.println(user);
		return user;
	}

	@RequestMapping("/admin")
	@CrossOrigin("*")
	public Principal admin(Principal user) {
		return user;
	}
}