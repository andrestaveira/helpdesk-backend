package com.andretaveira.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
