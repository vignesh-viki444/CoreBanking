package com.javatodev.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatodev.insurance.dto.Claim;
import com.javatodev.insurance.repository.ClaimRepository;

@Repository
public class ClaimDao {
	
	@Autowired
	private ClaimRepository claimRepository;
	
	//insert claim-------------------------------------------------------------
	public Claim insertClaim(Claim claim) {
		
		return claimRepository.save(claim);
		
	}
	
	//getBy claim id-----------------------------------------------------------------
	public Claim getByClaimId(int claimId) {
		Optional<Claim> optional = claimRepository.findById(claimId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	//delete claim-----------------------------------------------------------------
	
	public Claim deleteClaim(Claim claim, int claimId) {
		Optional<Claim> optional = claimRepository.findById(claimId);
		
		if (optional.isPresent()) {
			claimRepository.delete(optional.get());
			return claim;
		} else {
			return null;
		}
	}
	
	//update claim---------------------------------------------------------------
	
	public Claim updateClaim(Claim claim) {
		return claimRepository.save(claim);
		
	}
	
	//display all claim-----------------------------------------------------------------
	
	public List<Claim> displayAllClaim(){
		
		return claimRepository.findAll();
		
	}
	
}
