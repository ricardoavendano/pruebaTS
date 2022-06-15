package com.co.prueba.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.prueba.datatransfer.ActividadDTO;
import com.co.prueba.datatransfer.EmpleadoDTO;
import com.co.prueba.datatransfer.Exito;
import com.co.prueba.domain.Actividad;
import com.co.prueba.domain.Empleado;
import com.co.prueba.exception.ActividadException;
import com.co.prueba.repository.ActividadRepository;
import com.co.prueba.service.ActividadService;

import fj.data.Either;

@Service
public class ActividadServiceImp implements ActividadService {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	@Autowired
	private ActividadRepository actividadRepository;

	@Override
	public Either<Exception, Exito> crearActividad(ActividadDTO actividadDTO) {
		try {

			Actividad actividad = new Actividad();
			if (!actividadDTO.getIdActividad().equals(Long.valueOf(0))) {
				actividad.setIdActividad(actividadDTO.getIdActividad());

				Either<Exception, Actividad> actividadBuscar = buscarActividad(actividadDTO.getIdActividad());
				if (actividadBuscar.isLeft()) {
					return Either.left(new ActividadException("No se encontro actividad"));
				}
			} else {
				actividad.setIdActividad(Long.valueOf(0));
			}
			actividad.setEstado(actividadDTO.getEstado());
			actividad.setFechaCierre(actividadDTO.getFechaCierre() != null ? new SimpleDateFormat(DATE_FORMAT).parse(actividadDTO.getFechaCierre()) : null);
			actividad.setFechaEjecucion(actividadDTO.getFechaEjecucion() != null ? new SimpleDateFormat(DATE_FORMAT).parse(actividadDTO.getFechaEjecucion()) : null);

			Empleado empleado = new Empleado();
			empleado.setIdEmpleado(actividadDTO.getIdEmpleado().getIdEmpleado());

			actividad.setIdEmpleadopk(empleado);
			actividadRepository.save(actividad);
			if (!actividadDTO.getIdActividad().equals(Long.valueOf(0))) {
				Exito exito = new Exito("200", "Actividad editada con exito");
				return Either.right(exito);
			} else {
				Exito exito = new Exito("200", "Actividad creada con exito");
				return Either.right(exito);
			}

		} catch (Exception e) {
			return Either.left(new ActividadException("No es posible crear actividad"));
		}
	}

	@Override
	public Either<Exception, Exito> eliminarActividad(Long actividadId) {
		try {

			Either<Exception, Actividad> actividad = buscarActividad(actividadId);
			if (actividad.isRight()) {
				actividadRepository.delete(actividad.right().value());
				Exito exito = new Exito("200", "Actividad eliminada con exito");
				return Either.right(exito);
			} else {
				return Either.left(new ActividadException("No se encontro actividad"));
			}

		} catch (Exception e) {
			return Either.left(new ActividadException("No es posible crear actividad"));
		}
	}

	private Either<Exception, Actividad> buscarActividad(Long actividadId) {
		Optional<Actividad> actividad = actividadRepository.findById(actividadId);
		if (actividad.isPresent()) {
			return Either.right(actividad.get());
		} else {
			return Either.left(null);
		}
	}

	@Override
	public Either<Exception, List<ActividadDTO>> listarActividades() {
		try {
			List<Actividad> actividadList = (List<Actividad>) actividadRepository.findAll();
			if (!actividadList.isEmpty()) {
				List<ActividadDTO> listaActividad = new ArrayList<>();
				for (Actividad actividad : actividadList) {
					ActividadDTO actividadDTO = new ActividadDTO();

					actividadDTO.setIdActividad(actividad.getIdActividad());
					actividadDTO.setEstado(actividad.getEstado());
					DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
					actividadDTO.setFechaCierre(
							actividad.getFechaCierre() != null ? dateFormat.format(actividad.getFechaCierre()) : null);
					actividadDTO.setFechaEjecucion(
							actividad.getFechaEjecucion() != null ? dateFormat.format(actividad.getFechaEjecucion())
									: null);

					if (actividad.getFechaCierre() == null) {
						actividadDTO.setDiasRetraso((new Date(System.currentTimeMillis()).getTime()
								- actividad.getFechaEjecucion().getTime()) / 86400000);
						if(actividadDTO.getDiasRetraso() < 0) {
							actividadDTO.setDiasRetraso(Long.valueOf(0));	
						}
					} else {
						actividadDTO.setDiasRetraso(Long.valueOf(0));
					}

					EmpleadoDTO empleadoDTO = new EmpleadoDTO();
					empleadoDTO.setIdEmpleado(actividad.getIdEmpleadopk().getIdEmpleado());
					empleadoDTO.setNombre(actividad.getIdEmpleadopk().getNombre());
					actividadDTO.setIdEmpleado(empleadoDTO);

					listaActividad.add(actividadDTO);

				}
				return Either.right(listaActividad);
			} else {
				return Either.left(new ActividadException("No se encontraron resultados"));
			}

		} catch (Exception e) {
			return Either.left(new ActividadException("Consultando actividades"));
		}
	}
}
