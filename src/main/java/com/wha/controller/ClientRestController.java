package com.wha.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.dao.ClientDao;
import com.wha.model.Client;

@RestController
public class ClientRestController {
	private ClientDao clientDAO;

	public ClientRestController() {
		this.clientDAO = new ClientDao();
	}

	@GetMapping("/clients")
	public List<Client> getClients() {
		return clientDAO.list();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {

		Client client = clientDAO.get(id);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping(value = "/clients")
	public ResponseEntity<Client> createCustomer(@RequestBody Client client){
		
		clientDAO.create(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Long> deleteClient(@PathVariable Long id) {

		if (null == clientDAO.delete(id)) {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
		client = clientDAO.update(id, client);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
