package com.polytech.annuaire.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity 
@Data
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String name; 
	private String username;
	private String password;
	private String role;
	private boolean approved;
	
	public User(Long id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public User(Long id, String name, String username, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
	}
	
}