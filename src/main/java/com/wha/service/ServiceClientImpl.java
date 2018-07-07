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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		clientDao.save(client);
	}

	@Override
	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return clientDao.findAllClients();
	}

	@Override
	public Client findById(int id) {
		return clientDao.findById(id);
	}

	@Override
	public void updateClient(Client client) {
		clientDao.updateClient(client);
	}
	@Override
	public void deleteClientById(int id) {
		clientDao.deleteClientById(id);
		
	}

}