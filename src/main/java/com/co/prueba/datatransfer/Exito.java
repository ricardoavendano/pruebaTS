package com.co.prueba.datatransfer;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class Exito {

	private final String code;
	private final String description;

	public Exito(String code, String description) {

		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
