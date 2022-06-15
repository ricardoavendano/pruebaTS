package com.co.prueba.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

	private static final long serialVersionUID = -5936329650033303260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "idactividad")
	private Long idActividad;

	@Column(nullable = false, name = "estado")
	private Long estado;

	@Column(nullable = false, name = "fechaejecucion")
	private Date fechaEjecucion;

	@Column(nullable = false, name = "fechacierre")
	private Date fechaCierre;

	@JoinColumn(name = "IDEMPLEADOPK", referencedColumnName = "IDEMPLEADO", nullable = false)
	@ManyToOne(optional = false)
	private Empleado idEmpleadopk;

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

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Empleado getIdEmpleadopk() {
		return idEmpleadopk;
	}

	public void setIdEmpleadopk(Empleado idEmpleadopk) {
		this.idEmpleadopk = idEmpleadopk;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idActividad != null ? idActividad.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Actividad)) {
			return false;
		}
		Actividad other = (Actividad) object;
		if ((this.idActividad == null && other.idActividad != null)
				|| (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Actividad[ idActividad=" + idActividad + " ]";
	}

}
