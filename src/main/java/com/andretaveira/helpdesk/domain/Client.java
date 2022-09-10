package com.andretaveira.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.andretaveira.helpdesk.domain.dtos.ClientDTO;
import com.andretaveira.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends Person {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Call> calls = new ArrayList<>();

	public Client() {
		super();
		addProfile(Profile.CLIENTE);
	}

	public Client(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENTE);
	}
	
	public Client(ClientDTO obj) {
		id = obj.getId();
		name = obj.getName();
		cpf = obj.getCpf();
		email = obj.getEmail();
		password = obj.getPassword();
		profiles = obj.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
		createdAt = obj.getCreatedAt();
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}
}
