package com.javatodev.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.javatodev.insurance.dto.Claim;

@Component
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
