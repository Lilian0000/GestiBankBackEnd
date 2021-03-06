package com.wha.model;

import java.util.Date;
import java.util.List;

public class Conseiller extends User {

	public Conseiller() {
		super();
	}

	public Conseiller(Long id, String firstName, String lastName, String email, String mobile, String address,
			Date dateOfBirth, List<Client> clients) {
		super(id, firstName, lastName, email, mobile, address, dateOfBirth);
		this.clients = clients;
	}

	private List<Client> clients;

	public Conseiller(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
