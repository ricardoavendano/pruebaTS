package com.co.prueba.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.co.prueba.domain.Actividad;

@Component
public interface ActividadRepository extends CrudRepository<Actividad, Long> {

}
