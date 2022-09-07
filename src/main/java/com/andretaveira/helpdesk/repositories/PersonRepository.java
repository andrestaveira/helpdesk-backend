package com.andretaveira.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andretaveira.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
}
