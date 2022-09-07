package com.andretaveira.helpdesk.domain.enums;

public enum Status {

	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer code;
	private String description;

	private Status(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Status toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (Status p : Status.values()) {
			if (code.equals(p.getCode())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}
}
