package com.wha.model;

import java.util.Date;
import java.util.List;

public class Client extends User {

	private List<Compte> comptes;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Client() {
		super();
	}

	public Client(Long id, String firstName, String lastName, String email, String mobile, Date date, String address, List<Compte> comptes) {
		super(id, firstName, lastName, email, mobile, address, date);
		this.comptes = comptes;
	}

}
