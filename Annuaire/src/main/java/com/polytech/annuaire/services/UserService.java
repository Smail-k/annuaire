package com.polytech.annuaire.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.polytech.annuaire.model.User;


@Service
public interface UserService {
	User saveUser(User user);	
	User getUser(String username);
	List<User> getUsers();
	boolean userExist(String username);
}