package com.wha.service;

import java.util.List;

import com.wha.model.Client;

public interface ServiceClient {
	Client findClientByName(String name);

	void saveClient(Client client);

	List<Client> findAllClients();

	Client findById(int id);

	void save(Client client);

	void deleteClientById(int id);

	Client updateClient(Client client);
}
