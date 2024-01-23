package com.polytech.annuaire;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.polytech.annuaire.models.Contact;
import com.polytech.annuaire.repos.ContactRepository;


@EnableEurekaClient
@SpringBootApplication
public class EntryPoint {

	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
	
	@Bean
	CommandLineRunner run(ContactRepository repo) {
		return args->{
			//repo.save(new Contact(null, "smail", "PO", "doing something")); 
		};
	}
	
}