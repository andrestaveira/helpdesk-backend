package com.andretaveira.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.andretaveira.helpdesk.domain.Call;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CallDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate finishedAt;
	private Integer priority;
	private Integer status;
	private String title;
	private String body;
	private Integer operatorId;
	private Integer clientId;
	private String operatorName;
	private String clientName;
	
	public CallDTO() {
		
	}

	public CallDTO(Call obj) {
		this.id = obj.getId();
		this.createdAt = obj.getCreatedAt();
		this.finishedAt = obj.getFinishedAt();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.body = obj.getBody();
		this.operatorId = obj.getOperator().getId();
		this.clientId = obj.getClient().getId();
		this.operatorName = obj.getOperator().getName();
		this.clientName = obj.getClient().getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(LocalDate finishedAt) {
		this.finishedAt = finishedAt;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}
