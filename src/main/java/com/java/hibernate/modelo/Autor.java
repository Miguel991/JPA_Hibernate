package com.java.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTORES")
public class Autor {
	
	@Id
	@Column(name = "ID_AUTOR")
	private Long id;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	
	@OneToMany(mappedBy =  "autor", cascade = CascadeType.ALL)
	private List<Libro> listaLibro = new ArrayList<>();
	
	public Autor(){}
	
	

	public Autor(Long id, String nombre, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(List<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
	private void addLibro(Libro libro) {
		if(!listaLibro.contains(libro)){
			listaLibro.add(libro);
			libro.setAutor(this);
		}
	}
	private void removeLibro(Libro libro) {
		if(listaLibro.contains(libro)){
			listaLibro.remove(libro);
			libro.setAutor(null);
		}

	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
	

}
