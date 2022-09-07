package com.andretaveira.helpdesk.domain.enums;

public enum Priority {

	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer code;
	private String description;

	private Priority(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Priority toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (Priority p : Priority.values()) {
			if (code.equals(p.getCode())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida");
	}
}
