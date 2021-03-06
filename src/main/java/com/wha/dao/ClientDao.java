package com.wha.dao;

import java.util.List;

import com.wha.model.Client;

public interface ClientDao {

	Client findById(int id);

	Client findByName(String name);

	void save(Client user);

	void deleteClientById(int id);

	List<Client> findAllClients();

	void deleteAllClients();

	Client updateClient(Client user);

}
