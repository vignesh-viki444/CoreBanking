package com.javatodev.insurance.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Claim {

	@Id
	@Column(name = "claimId")
	private int claimID;
	
	@Column(name = "claimNumber")
	private long claimNumber;
	
	@Column(name = "claimDescription")
	private String claimDescription;
	
	@Column(name = "claimDate")
	private String claimDate;
	
	@Column(name= "claimStatus")
	private String claimStatus;
	
	@OneToOne
	@JoinColumn(name="policyID")
	private InsurancePolicy insurancePolicy;

	public int getClaimID() {
		return claimID;
	}

	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}

	public long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimDescription() {
		return claimDescription;
	}

	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

}
