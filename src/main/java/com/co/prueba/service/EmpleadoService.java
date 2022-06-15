package com.co.prueba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.prueba.datatransfer.EmpleadoDTO;
import com.co.prueba.datatransfer.Exito;

import fj.data.Either;

@Service
public interface EmpleadoService {

	public Either<Exception, Exito> crearEmpleado(String nombre);

	public Either<Exception, List<EmpleadoDTO>> listarEmpleados();

}
