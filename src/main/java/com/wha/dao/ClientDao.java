package com.wha.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wha.model.Client;
import com.wha.model.Compte;

public class ClientDao {

	public ClientDao() {

	}

	private static List<Client> clients;
	{
		List<Compte> comptes1 = new ArrayList<Compte>();
		comptes1.add(new Compte(1001L, "Compte courant", new Date(), 0L));
		List<Compte> comptes2 = new ArrayList<Compte>();
		comptes2.add(new Compte(1002L, "Compte courant", new Date(), 0L));
		List<Compte> comptes3 = new ArrayList<Compte>();
		comptes3.add(new Compte(1003L, "Compte courant", new Date(), 0L));
		
		clients = new ArrayList<Client>();
		clients.add(new Client(10L, "John", "Doe", "[email protected]", "121-232-3435", new Date(), "Ici", comptes1));
		clients.add(new Client(20L, "Russ", "Smith", "[email protected]", "343-232-3435", new Date(), "Là", comptes2));
		clients.add(new Client(30L, "Kate", "Williams", "[email protected]", "876-232-3435", new Date(), "Là bas",comptes3));
	}

	public List<Client> list() {
		return clients;
	}

	public Client get(Long id) {
		for (Client c : clients) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public Client create(Client client) {
		client.setId(System.currentTimeMillis());
		clients.add(client);
		return client;
	}

	public Long delete(Long id) {
		for (Client c : clients) {
			if (c.getId().equals(id)) {
				clients.remove(c);
				return id;
			}
		}
		return null;
	}

	public Client update(Long id, Client client) {
		for (Client c : clients) {
			if (c.getId().equals(id)) {
				client.setId(c.getId());
				clients.remove(c);
				clients.add(client);
				return client;
			}
		}
		return null;
	}

}
