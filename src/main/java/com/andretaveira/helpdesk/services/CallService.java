package com.andretaveira.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andretaveira.helpdesk.domain.Call;
import com.andretaveira.helpdesk.domain.Client;
import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.dtos.CallDTO;
import com.andretaveira.helpdesk.domain.enums.Priority;
import com.andretaveira.helpdesk.domain.enums.Status;
import com.andretaveira.helpdesk.repositories.CallRepository;
import com.andretaveira.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CallService {

	@Autowired
	private CallRepository repository;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private ClientService clientService;

	@Transactional(readOnly = true)
	public Call findById(Integer id) {
		Optional<Call> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado"));
	}

	@Transactional(readOnly = true)
	public List<Call> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Call create(@Valid CallDTO objDto) {
		return repository.save(newCall(objDto));
	}

	private Call newCall(CallDTO obj) {
		Operator operator = operatorService.findById(obj.getOperatorId());
		Client client = clientService.findById(obj.getClientId());
		Call call = new Call();
		if (obj.getId() != null) {
			call.setId(obj.getId());
		}
		if (obj.getStatus().equals(2)) {
			call.setFinishedAt(LocalDate.now());
		}
		call.setOperator(operator);
		call.setClient(client);
		call.setPriority(Priority.toEnum(obj.getPriority()));
		call.setStatus(Status.toEnum(obj.getStatus()));
		call.setTitle(obj.getTitle());
		call.setBody(obj.getBody());
		return call;
	}

	@Transactional
	public Call update(Integer id, @Valid CallDTO objDto) {
		objDto.setId(id);
		Call obj = findById(id);
		obj = newCall(objDto);
		return repository.save(obj);
	}
}
