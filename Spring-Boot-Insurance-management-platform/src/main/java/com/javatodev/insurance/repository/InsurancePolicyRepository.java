package com.javatodev.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.javatodev.insurance.dto.InsurancePolicy;

@Component
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

}
