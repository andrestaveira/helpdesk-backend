package com.andretaveira.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.andretaveira.helpdesk.domain.enums.Profile;

@Entity
public class Operator extends Person {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "operator")
	private List<Call> calls = new ArrayList<>();

	public Operator() {
		super();
		addProfile(Profile.CLIENTE);
	}

	public Operator(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENTE);
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}
}
