package com.polytech.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polytech.annuaire.models.Contact;
import com.polytech.annuaire.repos.ContactRepository;

@Service
public class ContactServiceDefault implements ContactService{

	@Autowired
	private ContactRepository repo;
	
	@Override
	public Contact addContact(Contact c) {
		return repo.save(c);
	}

	@Override
	public Contact modifyContact(Contact c) {
		return repo.save(c);
	}

	@Override
	public void deleteContact(Contact c) {
		repo.delete(c);
	}

	@Override 
	public List<Contact> getContactsByName(String name) {
		return repo.findContactsByfullNameContaining(name);
	}


}
