package com.co.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.datatransfer.EmpleadoDTO;
import com.co.prueba.datatransfer.Error;
import com.co.prueba.datatransfer.Exito;
import com.co.prueba.service.EmpleadoService;
import com.co.prueba.service.ErrorService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private ErrorService errorService;

	@PostMapping(value = "/crearEmpleado")
	public ResponseEntity<?> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {

		Either<Exception, Exito> resultEither = empleadoService.crearEmpleado(empleadoDTO.getNombre());

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/listarEmpleado")
	public ResponseEntity<?> listarEmpleados() {

		Either<Exception, List<EmpleadoDTO>> resultEither = empleadoService.listarEmpleados();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
