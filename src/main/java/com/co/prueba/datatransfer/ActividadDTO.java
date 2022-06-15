package com.co.prueba.datatransfer;

public class ActividadDTO {

	private Long idActividad;
	private Long estado;
	private String fechaEjecucion;
	private String fechaCierre;
	private Long diasRetraso;
	private EmpleadoDTO idEmpleado;

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(String fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(String fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Long getDiasRetraso() {
		return diasRetraso;
	}

	public void setDiasRetraso(Long diasRetraso) {
		this.diasRetraso = diasRetraso;
	}

	public EmpleadoDTO getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(EmpleadoDTO idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

}
