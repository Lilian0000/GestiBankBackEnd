package com.wha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wha.model.Client;
import com.wha.model.Compte;
import com.wha.service.ServiceClient;

@RestController
public class ClientRestController {

	@Autowired
	private ServiceClient serviceClient;

	public ClientRestController() {
	}

	@GetMapping("/clients")
	public List<Client> getClients() {
		return serviceClient.findAllClients();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {

		Client client = serviceClient.findById(id);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@GetMapping("/clients/{id}/comptes")
	public ResponseEntity<List<Compte>> getComptes(@PathVariable("id") int id) {

		Client client = serviceClient.findById(id);

		if (null == client) {
			return new ResponseEntity<List<Compte>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Compte>>(client.getComptes(), HttpStatus.OK);
	}

	@PostMapping(value = "/clients")
	public ResponseEntity<Client> createCustomer(@RequestBody Client client) {

		serviceClient.save(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Integer> deleteClient(@PathVariable int id) {

		serviceClient.deleteClientById(id);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
		client = serviceClient.updateClient(client);

		if (null == client) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
