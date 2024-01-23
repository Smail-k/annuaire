package com.polytech.annuaire.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.polytech.annuaire.model.User;
import com.polytech.annuaire.repos.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service @Transactional
public class UserServiceDefault implements UserService,UserDetailsService{

	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("secretaire"));
		if(user.getRole() !=null && user.getRole().equals("admin")) {
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
			//System.out.println("-------------------");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}	
	
	@Override
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	} 

	@Override
	public User getUser(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public boolean userExist(String username) {
		return getUser(username)!=null;
	}
}
