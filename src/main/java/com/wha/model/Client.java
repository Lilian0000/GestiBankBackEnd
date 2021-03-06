package com.wha.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CLIENT")
public class Client extends User {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	public Client(Long id, String firstName, String lastName, String email, String mobile, Date date, String address,
			List<Compte> comptes) {
		super(id, firstName, lastName, email, mobile, address, date);
		this.comptes = comptes;
	}

}
