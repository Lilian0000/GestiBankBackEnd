package com.wha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.dao.ClientDao;
import com.wha.model.Client;

@Service("serviceClientImpl")
public class ServiceClientImpl implements ServiceClient {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client findClientByName(String name) {
		return findClientByName(name);
	}

	@Override
	public void saveClient(Client client) {
		clientDao.save(client);
	}

	@Override
	public List<Client> findAllClients() {
		return clientDao.findAllClients();
	}

	@Override
	public Client findById(int id) {
		return clientDao.findById(id);
	}

	@Override
	public void save(Client client) {
		clientDao.save(client);
	}

	@Override
	public void deleteClientById(int id) {
		clientDao.deleteClientById(id);		
	}

	@Override
	public Client updateClient(Client client) {
		return clientDao.updateClient(client);
	}

}
