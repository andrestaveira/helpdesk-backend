package com.andretaveira.helpdesk.domain.enums;

public enum Profile {

	ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), OPERADOR(2, "ROLE_OPERADOR");

	private Integer code;
	private String description;

	private Profile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		for (Profile p : Profile.values()) {
			if (code.equals(p.getCode())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}
}
