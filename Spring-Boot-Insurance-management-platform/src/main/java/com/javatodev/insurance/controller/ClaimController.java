package com.javatodev.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatodev.insurance.dto.Claim;
import com.javatodev.insurance.dto.ResponseStructure;
import com.javatodev.insurance.service.ClaimService;

@RestController
@RequestMapping("/api")
public class ClaimController {
	
	@Autowired
	private ClaimService claimService;
	
	
	// insert claim ------------------------------------------
	
	@PostMapping("/saveClaim/{policyId}")
	public ResponseStructure<Claim> insertClaim(@RequestBody Claim claim, @PathVariable int policyId){
		
		return claimService.insertClaim(claim, policyId);
		
	}
	
	// getbyclaimid-------------------------------------------------
	
	@GetMapping("/getByClaimId/{claimId}")
	public ResponseStructure<Claim> getByClaimId(@PathVariable int claimId){
		
		return claimService.getByClaimId(claimId);
	}
	
	//delete claim------------------------------------------------------------
	
	@DeleteMapping("/deleteClaim/{claimId}")
	public ResponseStructure<Claim> deleteClaim(Claim claim, @PathVariable int claimId){
		
		return claimService.deleteClaim(claim, claimId);
		
	}
	
	//update claim--------------------------------------------------------
	
	@PutMapping("/updateClaim/{claimId}")
	public ResponseStructure<Claim> UpdateClaim(@RequestBody Claim claim, @PathVariable int claimId){
		
		        return claimService.updateClaim(claim, claimId);
	}
	
	
	

}
