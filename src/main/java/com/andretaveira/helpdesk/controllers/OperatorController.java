package com.andretaveira.helpdesk.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.dtos.OperatorDTO;
import com.andretaveira.helpdesk.services.OperatorService;

@RestController
@RequestMapping(value = "/operators")
public class OperatorController {

	@Autowired
	private OperatorService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OperatorDTO> findById(@PathVariable Integer id) {
		Operator obj = service.findById(id);
		return ResponseEntity.ok().body(new OperatorDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<OperatorDTO>> findAll() {
		List<Operator> list = service.findAll();
		List<OperatorDTO> listDto = list.stream().map(op -> new OperatorDTO(op)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PostMapping
	public ResponseEntity<OperatorDTO> create(@Valid @RequestBody OperatorDTO objDto) {
		Operator obj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
