package com.andretaveira.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
