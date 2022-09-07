package com.andretaveira.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretaveira.helpdesk.domain.Call;

public interface CallRepository extends JpaRepository<Call, Integer>{
	
}
