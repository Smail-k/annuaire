package com.polytech.annuaire.services;

import java.util.List;

import com.polytech.annuaire.models.Contact;

public interface ContactService {

	public Contact addContact(Contact c);
	public Contact modifyContact(Contact c);
	public void deleteContact(Contact c);
	public List<Contact> getContactsByName(String name);
}
