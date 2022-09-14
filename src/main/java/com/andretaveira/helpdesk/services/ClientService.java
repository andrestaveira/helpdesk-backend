package com.andretaveira.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andretaveira.helpdesk.domain.Client;
import com.andretaveira.helpdesk.domain.Person;
import com.andretaveira.helpdesk.domain.dtos.ClientDTO;
import com.andretaveira.helpdesk.repositories.ClientRepository;
import com.andretaveira.helpdesk.repositories.PersonRepository;
import com.andretaveira.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.andretaveira.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}

	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Client create(ClientDTO objDto) {
		objDto.setId(null);
		objDto.setPassword(passwordEncoder.encode(objDto.getPassword()));
		validateCpfAndEmail(objDto);
		Client obj = new Client(objDto);
		return repository.save(obj);
	}

	@Transactional
	public Client update(Integer id, @Valid ClientDTO objDto) {
		objDto.setId(id);
		Client obj = findById(id);
		validateCpfAndEmail(objDto);
		obj = new Client(objDto);
		return repository.save(obj);
	}

	@Transactional
	public void delete(Integer id) {
		Client obj = findById(id);
		if (obj.getCalls().size() > 0) {
			throw new DataIntegrityViolationException("O cliente possui chamados vinculados e não pode ser deletado");
		}
		repository.deleteById(id);
	}

	private void validateCpfAndEmail(ClientDTO objDto) {
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
