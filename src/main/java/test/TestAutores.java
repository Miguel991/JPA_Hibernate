package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.hibernate.modelo.Autor;
import com.java.hibernate.modelo.Libro;

public class TestAutores {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crearDatos();
		imprimirDatos();

	}

	private static void imprimirDatos() {
		EntityManager em = emf.createEntityManager();
		
		//7Autor autor = em.find(Autor.class, 2L);
		//List<Libro> libro = autor.getListaLibro();
		
		//for(Libro libros : libro){
			//System.out.println("* "+libro.toString());
		//}
 //		System.out.println(autor);
		em.close();
	}

	private static void crearDatos() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Autor autorUno = new Autor(1L,"Pablo lopez","Español");
		Autor autorDos = new Autor(2L,"Elena Gomez","Mexico");
		Autor autorTres = new Autor(3L,"Miguel Perez","Argentino");
		em.persist(autorUno);
		em.persist(autorDos);
		em.persist(autorTres);

		/*we do not need the instances of the book class,so we only
		 * persist the data entered directly*/
		em.persist(new Libro(1L,"Aprendiendo java",autorUno));
		em.persist(new Libro(2L,"La sopa y la mosca",autorDos));
		em.persist(new Libro(3L,"El Alquimista",autorTres));


		
		em.getTransaction().commit();
		
		em.close();
	}
	

}
