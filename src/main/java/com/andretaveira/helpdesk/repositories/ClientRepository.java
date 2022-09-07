package com.andretaveira.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretaveira.helpdesk.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}
