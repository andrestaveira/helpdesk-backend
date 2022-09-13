package com.andretaveira.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andretaveira.helpdesk.domain.Call;
import com.andretaveira.helpdesk.repositories.CallRepository;
import com.andretaveira.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CallService {

	@Autowired
	private CallRepository repository;
	
	public Call findById(Integer id) {
		Optional<Call> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado não encontrado"));
	}
}
