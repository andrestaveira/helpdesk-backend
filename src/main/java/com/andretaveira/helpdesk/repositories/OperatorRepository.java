package com.andretaveira.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretaveira.helpdesk.domain.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Integer>{
	
}
