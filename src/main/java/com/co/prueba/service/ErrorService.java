package com.co.prueba.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.co.prueba.datatransfer.Error;
import com.co.prueba.exception.ActividadException;
import com.co.prueba.exception.EmpleadoException;

@Service
public class ErrorService {

	public Error getError(Exception e) {

		if (e instanceof EmpleadoException) {
			return new Error("EstadoCompraException", "Error: " + ((EmpleadoException) e).getCausaError());
		}

		if (e instanceof ActividadException) {
			return new Error("ActividadException", "Error: " + ((ActividadException) e).getCausaError());
		}

		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("Prueba", "Unknown Error");
	}
}
