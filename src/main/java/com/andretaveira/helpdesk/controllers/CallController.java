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

import com.andretaveira.helpdesk.domain.Call;
import com.andretaveira.helpdesk.domain.dtos.CallDTO;
import com.andretaveira.helpdesk.services.CallService;

@RestController
@RequestMapping(value = "/calls")
public class CallController {

	@Autowired
	private CallService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CallDTO> findById(@PathVariable Integer id) {
		Call obj = service.findById(id);
		return ResponseEntity.ok().body(new CallDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<CallDTO>> findAll() {
		List<Call> list = service.findAll();
		List<CallDTO> listDto = list.stream().map(obj -> new CallDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<CallDTO> create(@Valid @RequestBody CallDTO objDto) {
		Call obj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
