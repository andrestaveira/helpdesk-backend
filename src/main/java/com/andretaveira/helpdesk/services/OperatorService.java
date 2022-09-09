package com.andretaveira.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.Person;
import com.andretaveira.helpdesk.domain.dtos.OperatorDTO;
import com.andretaveira.helpdesk.repositories.OperatorRepository;
import com.andretaveira.helpdesk.repositories.PersonRepository;
import com.andretaveira.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.andretaveira.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository repository;

	@Autowired
	private PersonRepository personRepository;

	public Operator findById(Integer id) {
		Optional<Operator> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Operador não encontrado"));
	}

	public List<Operator> findAll() {
		return repository.findAll();
	}

	public Operator create(OperatorDTO objDto) {
		objDto.setId(null);
		validateCpfAndEmail(objDto);
		Operator obj = new Operator(objDto);
		return repository.save(obj);
	}

	public Operator update(Integer id, @Valid OperatorDTO objDto) {
		objDto.setId(id);
		Operator obj = findById(id);
		validateCpfAndEmail(objDto);
		obj = new Operator(objDto);
		return repository.save(obj);
	}

	private void validateCpfAndEmail(OperatorDTO objDto) {
		Optional<Person> obj = personRepository.findByCpf(objDto.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("O CPF informado já existe");
		}

		obj = personRepository.findByEmail(objDto.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("O e-mail informado já existe");
		}
	}
}
