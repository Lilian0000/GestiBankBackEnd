package com.wha.dao;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.wha.model.Client;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

	@Override
	public Client findById(int id) {
		return getByKey(id);
	}

	@Override
	public Client findByName(String name) {
		return null;
	}

	@Override
	public void save(Client user) {
		persist(user);
	}

	@Override
	public void deleteClientById(int id) {
		delete(getByKey(id));
	}

	@Override
	public List<Client> findAllClients() {
		Query q = getEntityManager().createQuery("select c from Client c");
		return (List<Client>) q.getResultList();
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client updateClient(Client user) {
		update(user);
		return user;
		// TODO Auto-generated method stub
		
	}

}
