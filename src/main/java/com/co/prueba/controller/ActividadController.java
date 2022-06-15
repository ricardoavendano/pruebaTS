package com.co.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.datatransfer.ActividadDTO;
import com.co.prueba.datatransfer.Error;
import com.co.prueba.datatransfer.Exito;
import com.co.prueba.service.ActividadService;
import com.co.prueba.service.ErrorService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class ActividadController {

	@Autowired
	private ActividadService actividadService;

	@Autowired
	private ErrorService errorService;

	@PostMapping(value = "/crearActividad")
	public ResponseEntity<?> crearActividad(@RequestBody ActividadDTO actividadDTO) {

		Either<Exception, Exito> resultEither = actividadService.crearActividad(actividadDTO);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/eliminarActividad/{actividadId}")
	public ResponseEntity<?> eliminarActividad(@PathVariable Long actividadId) {

		Either<Exception, Exito> resultEither = actividadService.eliminarActividad(actividadId);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/listarActividad")
	public ResponseEntity<?> listarActividades() {

		Either<Exception, List<ActividadDTO>> resultEither = actividadService.listarActividades();

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
