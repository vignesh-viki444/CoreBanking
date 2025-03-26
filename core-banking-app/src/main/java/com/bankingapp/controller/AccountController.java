package com.bankingapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingapp.entity.Account;
import com.bankingapp.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		
		return accountService.createAccount(account);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable Long id) {
		
		return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
		
	}
	
	
	@PostMapping("/{id}/deposit")
	public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		
		
		Double amount = request.get("amount");
		
		return accountService.deposit(id, amount);
	}
	
	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		
		Double amount = request.get("amount");
		
		return accountService.withdraw(id, amount);
	}

	
	
	
}
