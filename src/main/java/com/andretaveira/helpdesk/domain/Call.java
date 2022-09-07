package com.andretaveira.helpdesk.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.andretaveira.helpdesk.domain.enums.Priority;
import com.andretaveira.helpdesk.domain.enums.Status;

public class Call {

	private Integer id;
	private LocalDate createdAt = LocalDate.now();
	private LocalDate finishedAt;
	private Priority priority;
	private Status status;
	private String title;
	private String body;
	private Operator operator;
	private Client client;
	
	public Call() {
		
	}

	public Call(Integer id, Priority priority, Status status, String title, String body, Operator operator,
			Client client) {
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.body = body;
		this.operator = operator;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public LocalDate getFinishedAt() {
		return finishedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Call other = (Call) obj;
		return Objects.equals(id, other.id);
	}
}
