package com.co.prueba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.prueba.datatransfer.ActividadDTO;
import com.co.prueba.datatransfer.Exito;

import fj.data.Either;

@Service
public interface ActividadService {

	public Either<Exception, Exito> crearActividad(ActividadDTO actividadDTO);

	public Either<Exception, Exito> eliminarActividad(Long actividadId);

	public Either<Exception, List<ActividadDTO>> listarActividades();

}
