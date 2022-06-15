package com.co.prueba.exception;

public class EmpleadoException extends Exception {

	private static final long serialVersionUID = -6990395161113342814L;

	private final String causaError;

	public EmpleadoException(String causaError) {
		this.causaError = causaError;
	}

	public String getCausaError() {
		return causaError;
	}
}
