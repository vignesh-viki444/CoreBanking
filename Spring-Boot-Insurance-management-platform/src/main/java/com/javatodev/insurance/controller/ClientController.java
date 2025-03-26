package com.javatodev.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatodev.insurance.dto.Client;
import com.javatodev.insurance.dto.ResponseStructure;
import com.javatodev.insurance.service.ClientService;


@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	//insert client------------------------------------------
	/*
	 * @PostMapping("/saveClient/{policyId}") public ResponseStructure<Client>
	 * insertClient(@RequestBody Client client,@PathVariable int policyId){ return
	 * clientService.insertClient(client, policyId);
	 */
	
	/*// getByClientId---------------------------------------------------------------------------------------
		@GetMapping("/getClientById/{clientId}")
		public ResponseStructure<Client> getClientById(@PathVariable int clientId) {
			return clientService.getClientById(clientId);*/
		}
	
		/*
		 * //update
		 * Client-----------------------------------------------------------------------
		 * ---------------
		 * 
		 * @PutMapping("/updateClient/{clientId}") public ResponseStructure<Client>
		 * updateClient(@RequestBody Client client,@PathVariable int clientId) { return
		 * clientService.updateClient(client, clientId);
		 * 
		 * }
		 */

		/*
		 * //delete
		 * Client-----------------------------------------------------------------------
		 * ------------------
		 * 
		 * @DeleteMapping("/deleteClient/{clientId}") public ResponseStructure<Client>
		 * deleteClient(Client client,@PathVariable int clientId) { return
		 * clientService.deleteClient(client, clientId); }
		 */

		/*
		 * //display
		 * Client-----------------------------------------------------------------------
		 * -----------------
		 * 
		 * @GetMapping("/displayAllClient") public ResponseStructure<List<Client>>
		 * displayAllCLient(){ return clientService.displayAllCLient(); } }
		 */
