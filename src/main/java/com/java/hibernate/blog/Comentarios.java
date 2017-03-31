package com.java.hibernate.blog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMENTARIOS")
public class Comentarios {
	@Id
	@Column(name = "ID_COMENTARIOS")
	private Long id;
	@Column(name = "TITULO")
	private String titulo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Publicaciones publicacion;
	
	public Comentarios(){}

	public Comentarios(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", titulo=" + titulo + ", publicacion=" + publicacion + "]";
	}

	public Publicaciones getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicaciones publicacion) {
		this.publicacion = publicacion;
	}
	
	

}
