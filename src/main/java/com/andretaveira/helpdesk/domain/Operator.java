package com.andretaveira.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator extends Person {

	private List<Call> calls = new ArrayList<>();

	public Operator() {
		super();
	}

	public Operator(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}
}
