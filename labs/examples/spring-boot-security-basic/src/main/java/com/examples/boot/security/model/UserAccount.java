package com.examples.boot.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class UserAccount {

    // Enable for JPA
	@Id
	@GeneratedValue
	long id;

	String username;
	String password;
	String role;
	boolean active;
	
	public UserAccount() {
		
	}

	public UserAccount(String username, String password, String role, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}