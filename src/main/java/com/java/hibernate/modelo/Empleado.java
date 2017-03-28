package com.java.hibernate.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "EMPLEADO")
public class Empleado implements Serializable {

	private static final long serialVersionUID = -7543286950807923622L;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_DIRECCION")
	private Direccion direccion;
	
	@Id
	@Column(name = "COD_EMPLEADO")
	private long codigo;
	
	@Column(name = "APELLIDOS")
	private String apellido;
	
	@Column (name = "NOMBRES")
	private String nombre;
	
	@Column(name = "FECHA_DE_NACIMIENTO")
	private LocalDate fechaNacimiento;
	
	public Empleado(){
		
	}

	public Empleado(long codigo, String apellido, String nombre, LocalDate fechaNacimiento) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empleado [direccion=" + direccion + ", codigo=" + codigo + ", apellido=" + apellido + ", nombre="
				+ nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
	
	
}
