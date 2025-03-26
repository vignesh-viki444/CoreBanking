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

import com.javatodev.insurance.dto.InsurancePolicy;
import com.javatodev.insurance.dto.ResponseStructure;
import com.javatodev.insurance.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {
	
	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	@PostMapping("/saveInsurancePolicy")
	public ResponseStructure<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		
                  return insurancePolicyService.insertInsurancePolicy(insurancePolicy);		
	}

	@GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
	public ResponseStructure<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId){
		         
		         return insurancePolicyService.getByInsurancePolicyId(insurancePolicyId);
	}
	
	@PutMapping("/updateInsurancePolicy/{insurancePolicyId}")
	public ResponseStructure<InsurancePolicy> updateInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy,@PathVariable int insurancePolicyId){
		
		        return insurancePolicyService.getByInsurancePolicyId(insurancePolicyId);
	}
	
	@DeleteMapping("/deleteInsurancePolicy/{policyId}")
	public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(InsurancePolicy insurancePolicy,@PathVariable int insurancePolicyId){
		
		       return insurancePolicyService.deleteInsurancePolicy(insurancePolicy, insurancePolicyId);
	}
	
	public ResponseStructure<List<InsurancePolicy>> displayAllPolicy(){
		
		      return insurancePolicyService.displayAllPolicy();
		
	}
	
}
