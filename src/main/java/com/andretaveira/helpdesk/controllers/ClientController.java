package com.andretaveira.helpdesk.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andretaveira.helpdesk.domain.Client;
import com.andretaveira.helpdesk.domain.dtos.ClientDTO;
import com.andretaveira.helpdesk.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) {
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(new ClientDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<Client> list = service.findAll();
		List<ClientDTO> listDto = list.stream().map(op -> new ClientDTO(op)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping
	public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDto) {
		Client obj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO objDto) {
		Client obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new ClientDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
