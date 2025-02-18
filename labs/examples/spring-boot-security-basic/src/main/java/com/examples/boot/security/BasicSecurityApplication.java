package com.examples.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.repo.UserRepository;

@SpringBootApplication
public class BasicSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Saving Password as plaintext
//		userRepository.save(new UserAccount("admin","{noop}admin",true));
//		userRepository.save(new UserAccount("user1","{noop}user1",true));

		// Saving Encrypted Password
		userRepository.save(new UserAccount("admin",encoder.encode("admin"),"ADMIN",true));
		userRepository.save(new UserAccount("manager",encoder.encode("manager"),"MANAGER",true));
		userRepository.save(new UserAccount("user",encoder.encode("user"),"USER",true));

		// Fetches list of users
		System.out.println(userRepository.findAll());
	}
}

