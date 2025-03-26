package com.javatodev.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatodev.insurance.repository.ClientRepository;

import ch.qos.logback.core.net.server.Client;

@Repository
public class ClientDao {
	
	@Autowired
	private ClientRepository clientRepository;

	public Client insertClient(Client client) {
		return clientRepository.save(client);
		
}

	public Client getClientById(int clientId) {
		Optional<Client> optional = clientRepository.findById(clientId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}
	
	
	public Client deleteClient(Client client, int clientId) {
		Optional<Client> optional = clientRepository.findById(clientId);
		
		if(optional.isPresent()) {
			clientRepository.delete(optional.get());
			return client;
		}else {
			return null;
		}
	}
	
	public List<Client> displayAllCLient(){
		return clientRepository.findAll();
		
	}
	}
	
	
	
	
	
	
	