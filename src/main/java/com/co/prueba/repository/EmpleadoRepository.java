package com.co.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.co.prueba.domain.Empleado;

@Component
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
