package com.java.hibernate.blog;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Blog {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	public static void main(String[] args){
		insertar();
		imprimir();
		borrar(2L);
		imprimir();
		emf.close();
		
	}

	private static void imprimir() {
		EntityManager manager = emf.createEntityManager();
		
		List<Publicaciones> publi = manager.createQuery("FROM Publicaciones",Publicaciones.class).getResultList();
		for(Publicaciones pub: publi){
			if(pub.getComentario().isEmpty()){
				System.out.println("No hay Comentarios");
			}else{
				System.out.println("hay "+pub.getComentario().size()+" comentario");
				for(Comentarios c: pub.getComentario()){
					System.out.println("*"+ c.toString());
				}
			}
		}
		manager.close();
		
	}
	private static void borrar(long idComentario){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Comentarios c = em.find(Comentarios.class, idComentario);
		Publicaciones p = c.getPublicacion();
		p.eliminarComentario(c);
		em.getTransaction().commit();
		em.close();
	}

	private static void insertar(){
		Publicaciones p = new Publicaciones(1L,"Hay sol");
		Comentarios c = new Comentarios(1L,"Aquí llueve");
		Comentarios cc = new Comentarios(2L,"Fuc***");
		p.insertarComentario(c);
		p.insertarComentario(cc);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
