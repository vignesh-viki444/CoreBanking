package com.javatodev.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.javatodev.insurance.dao.ClaimDao;
import com.javatodev.insurance.dao.InsurancePolicyDao;
import com.javatodev.insurance.dto.Claim;
import com.javatodev.insurance.dto.InsurancePolicy;
import com.javatodev.insurance.dto.ResponseStructure;
import com.javatodev.insurance.exception.IdNotFoundException;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimDao claimDao;
	
	@Autowired
	private InsurancePolicyDao insurancePolicyDao;
	
	@Autowired
	private ResponseStructure<Claim> responseStructure;
	
    @Autowired
	private ResponseStructure<List<Claim>> responseStructure2;
    
    
    //insert claim------------------------------------------------------------
    
    public ResponseStructure<Claim> insertClaim(Claim claim, int policyId){
    	
    	InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyID(policyId);
    	
    	if(insurancePolicy != null) {
    		claim.setInsurancePolicy(insurancePolicy);
    		claimDao.insertClaim(claim);
    		
    		responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
    		responseStructure.setMsg("Not Claimed yet please check again");
    		responseStructure.setData(null);
    		return responseStructure;
    	} else {
			
			  responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			  responseStructure.setMsg("Not Claimed yet please check again");
			  responseStructure.setData(null);
    		
    		return responseStructure; }
    		}
    //getbyclaimid----------------------------------------------------------------------
    
    public ResponseStructure<Claim> getByClaimId(int claimId){
    	
    	Claim claim = claimDao.getByClaimId(claimId);
    	
    	if(claim != null) {
    		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
    		responseStructure.setMsg("this claimid is present");
    		responseStructure.setData(claim);
    	} else {
			/*
			 * responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			 * responseStructure.
			 * setMsg("Please check claim id is not present in our database");
			 * responseStructure.setData(null); return responseStructure
			 */;
    	throw new IdNotFoundException("given id is not present in database");
    	}
    	return responseStructure;
    	}
    
    //deleteclaim--------------------------------------------------------------
    
    public ResponseStructure<Claim> deleteClaim(Claim claim, int claimId){
    	
    	Claim claim2 = claimDao.deleteClaim(claim, claimId);
    	
    	if(claim2 != null) {
    		responseStructure.setStatusCode(HttpStatus.FOUND.value());
    		responseStructure.setMsg("claim deleted successfully");
    		responseStructure.setData(claim2);
    	} else {
			/*
			 * responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			 * responseStructure.setMsg("Claim is not deleted ");
			 * responseStructure.setData(null); return responseStructure;
			 */
    		throw new IdNotFoundException("Given id is not present in database");
    	}
		return responseStructure;
    }
    
    //updateclaim---------------------------------------------------------------
    public ResponseStructure<Claim> updateClaim(Claim claim, int claimId){
    	
    	Claim claim2 = claimDao.getByClaimId(claimId);
    	
    	if(claim2 != null) {
    		claim2.setClaimNumber(claim.getClaimNumber());
    		claim2.setClaimDate(claim.getClaimDate());
    		claim2.setClaimDescription(claim.getClaimDescription());
    		claim2.setClaimStatus(claim.getClaimStatus());
    		
    		claimDao.updateClaim(claim2);
    		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
    		responseStructure.setMsg("claim updated successfully");
    		responseStructure.setData(claim2);
    	} else {
			/*
			 * responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			 * responseStructure.setMsg("Given id is not present in database");
			 * responseStructure.setData(null); return responseStructure;
			 */
    		
    		throw new IdNotFoundException("given id is not present in database");
    	}
    	return responseStructure;
    }
    
	/*
	 * display all claim----------------------------------------------------
	 */
    
    public ResponseStructure<List<Claim>> displayAllClaim(){
    	
    	List<Claim> claims = claimDao.displayAllClaim();
    	
    	if(claims != null) {
    		
    		responseStructure2.setStatusCode(HttpStatus.FOUND.value());
    		responseStructure2.setMsg("claims details");
    		responseStructure2.setData(claims);
    		return responseStructure2;
    	}
    	else {
    		responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
    		responseStructure2.setMsg("claims details are not available");
    		responseStructure2.setData(null);
    		return responseStructure2;
    	}
    	
    }
    
   }
    
    
    
    

