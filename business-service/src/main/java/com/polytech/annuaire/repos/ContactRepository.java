package com.polytech.annuaire.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.polytech.annuaire.models.Contact;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact,Long>{

	public Contact findContactByfullName(String fullName);
    @Query("SELECT c FROM Contact c WHERE LOWER(c.fullName) LIKE LOWER(CONCAT('%', :name, '%'))")
	public List<Contact> findContactsByfullNameContaining(String name);
}