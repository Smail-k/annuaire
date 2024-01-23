package com.polytech.annuaire;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.polytech.annuaire.model.User;
import com.polytech.annuaire.services.UserService;


@EnableEurekaClient
@CrossOrigin("*")
@SpringBootApplication
public class EntryPoint {

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
	
	@Bean 
	CommandLineRunner run(UserService userService) {
		return args->{
			userService.saveUser(new User(null,"smailox","smail","123","admin")); 
		};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
	}
}