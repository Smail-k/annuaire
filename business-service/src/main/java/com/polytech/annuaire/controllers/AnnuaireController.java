package com.polytech.annuaire.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polytech.annuaire.models.Contact;
import com.polytech.annuaire.services.ContactService;

@RestController
public class AnnuaireController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("contacts/search/{name}")
	public List<Contact> getContact(@PathVariable String name) {
		return contactService.getContactsByName(name);
	}
	
	@PostMapping("/contacts/add")
	public Contact addContact(@RequestBody Contact c) {
		return contactService.addContact(c);
	}
	
}