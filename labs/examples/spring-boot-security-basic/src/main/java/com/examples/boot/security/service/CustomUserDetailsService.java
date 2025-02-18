package com.examples.boot.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examples.boot.security.model.UserAccount;
import com.examples.boot.security.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserAccount userAccount =  this.userRepository.findByUsername(username).get();
//		return new User(userAccount.getUsername(), userAccount.getPassword(), AuthorityUtils.createAuthorityList("ROLE_" + userAccount.getRole()));

		// Java 8 implementation
		return this.userRepository.findByUsername(username)
				.map(u -> new User(u.getUsername(), u.getPassword(), u.isActive(), u.isActive(), u.isActive(),u.isActive(),
						AuthorityUtils.createAuthorityList("ROLE_" + u.getRole())))
				.orElseThrow(() -> new UsernameNotFoundException("Could not find User: " + username));
	}

}
