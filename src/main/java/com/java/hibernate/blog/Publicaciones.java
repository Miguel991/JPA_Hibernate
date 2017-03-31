package com.java.hibernate.blog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLICACIONES")
public class Publicaciones {
	
	@Id
	@Column(name = "ID_PUBLICACIONES")
	private Long id;
	@Column(name = "TITULO")
	private String titulo;
		
	@OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Comentarios> comentario = new ArrayList<>();
	
	public Publicaciones(){}

	public Publicaciones(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public void insertarComentario(Comentarios c) {
			comentario.add(c);
			c.setPublicacion(this);
		
				
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
		return "Publicaciones [id=" + id + ", titulo=" + titulo+ "]";
	}

	public List<Comentarios> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentarios> comentario) {
		this.comentario = comentario;
	}
	
	public void eliminarComentario(Comentarios c){
		if(comentario.contains(c)){
			comentario.remove(c);
			c.setPublicacion(null);
		}else{System.out.println("El comentario que se quiere eliminar no existe");}
		
	}
	
	
	
	

}
