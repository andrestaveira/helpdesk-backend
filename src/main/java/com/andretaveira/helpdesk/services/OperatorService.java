package com.andretaveira.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.repositories.OperatorRepository;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository repository;

	public Operator findById(Integer id) {
		Optional<Operator> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
