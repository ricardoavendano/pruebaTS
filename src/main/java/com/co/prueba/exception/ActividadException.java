package com.co.prueba.exception;

public class ActividadException extends Exception {

	private static final long serialVersionUID = 5413924602670036267L;

	private final String causaError;

	public ActividadException(String causaError) {
		this.causaError = causaError;
	}

	public String getCausaError() {
		return causaError;
	}
}
