package com.examples.boot.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.boot.security.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> { 
	
	public Optional<UserAccount> findByUsername(String userName);
	
}
