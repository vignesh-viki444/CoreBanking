package com.javatodev.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;import ch.qos.logback.core.net.server.Client;

@Component
public interface ClientRepository extends JpaRepository<Client, Integer>{

	com.javatodev.insurance.dto.Client save(com.javatodev.insurance.dto.Client client);

}
