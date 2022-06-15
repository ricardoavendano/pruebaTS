package com.co.prueba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.prueba.datatransfer.EmpleadoDTO;
import com.co.prueba.datatransfer.Exito;
import com.co.prueba.domain.Empleado;
import com.co.prueba.exception.EmpleadoException;
import com.co.prueba.repository.EmpleadoRepository;
import com.co.prueba.service.EmpleadoService;

import fj.data.Either;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public Either<Exception, Exito> crearEmpleado(String nombre) {
		try {
			Empleado empleado = new Empleado();
			empleado.setIdEmpleado(Long.valueOf(0));
			empleado.setNombre(nombre);
			empleadoRepository.save(empleado);
			Exito exito = new Exito("200", "Empleado creado con exito");
			return Either.right(exito);
		} catch (Exception e) {
			return Either.left(new EmpleadoException("No es posible crear empleado"));
		}
	}

	@Override
	public Either<Exception, List<EmpleadoDTO>> listarEmpleados() {
		try {
			List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
			if (!empleados.isEmpty()) {
				List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
				for (Empleado empleado : empleados) {
					EmpleadoDTO empleadoDTO = new EmpleadoDTO();
					empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
					empleadoDTO.setNombre(empleado.getNombre());
					listaEmpleados.add(empleadoDTO);
				}
				return Either.right(listaEmpleados);
			} else {
				return Either.left(new EmpleadoException("No se encontraron resultados"));
			}

		} catch (Exception e) {
			return Either.left(new EmpleadoException("Consultando empleados"));
		}
	}

}
