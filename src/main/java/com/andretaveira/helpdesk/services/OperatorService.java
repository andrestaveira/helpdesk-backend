package com.andretaveira.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.dtos.OperatorDTO;
import com.andretaveira.helpdesk.repositories.OperatorRepository;
import com.andretaveira.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository repository;

	public Operator findById(Integer id) {
		Optional<Operator> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Operador não encontrado"));
	}

	public List<Operator> findAll() {
		return repository.findAll();
	}

	public Operator create(OperatorDTO objDto) {
		objDto.setId(null);
		Operator obj = new Operator(objDto);
		return repository.save(obj);
	}
}
