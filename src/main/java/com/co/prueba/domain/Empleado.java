package com.co.prueba.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = -629636322850605729L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "idempleado")
	private Long idEmpleado;
	
	@Column(nullable = false, name = "nombre")
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleadopk")
	private List<Actividad> actividadList;

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@XmlTransient
	public List<Actividad> getActividadList() {
		return actividadList;
	}

	public void setActividadList(List<Actividad> actividadList) {
		this.actividadList = actividadList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Empleado)) {
			return false;
		}
		Empleado other = (Empleado) object;
		if ((this.idEmpleado == null && other.idEmpleado != null)
				|| (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Empleado[ idEmpleado=" + idEmpleado + " ]";
	}
}
