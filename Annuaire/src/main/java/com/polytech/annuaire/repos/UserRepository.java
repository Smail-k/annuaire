package com.polytech.annuaire.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.polytech.annuaire.model.User;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}