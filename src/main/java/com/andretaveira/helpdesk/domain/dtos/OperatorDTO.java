package com.andretaveira.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.andretaveira.helpdesk.domain.Operator;
import com.andretaveira.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OperatorDTO implements Serializable {

	protected static final long serialVersionUID = 1L;
	protected Integer id;
	protected String name;
	protected String cpf;
	protected String email;
	protected String password;
	protected Set<Integer> profiles = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate createdAt = LocalDate.now();

	public OperatorDTO() {

	}

	public OperatorDTO(Operator obj) {
		id = obj.getId();
		name = obj.getName();
		cpf = obj.getCpf();
		email = obj.getEmail();
		password = obj.getPassword();
		profiles = obj.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
		createdAt = obj.getCreatedAt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(p -> Profile.toEnum(p)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
}
