package test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		
		/*List<Empleado> empleados = (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta base de datos hay "+empleados.size()+" empleados");
		*/
		
		insertInicial();
		
		imprimirTodo();
		
		
		//Block of transactions
		manager.getTransaction().begin();
		Empleado e = manager.find(Empleado.class, 10L);
		e.setApellido("Mehert");
		e.setNombre("Gilberto");
		manager.getTransaction().commit();
		
		imprimirTodo();
		//close the manager when not in use
		manager.close();
		
		//Once we close the entity manager the entities are left
		//without any manager so with the merge method we can
		//re-administer the object of Empleado type
		
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		//re-administer the object Empleado type
		e = manager.merge(e);
		//rename
		e.setNombre("JUAN");
		//delete the object from the database
		manager.remove(e);
		manager.getTransaction().commit();
		manager.close();
		imprimirTodo();
	}
	private static void insertInicial() {
		Empleado e = new Empleado(10L,"Perez","Pepito",LocalDate.of(1889, 12, 23));
		Empleado i = new Empleado(9L,"Gates","Jose",LocalDate.of(1967, 12, 23));
		Empleado a = new Empleado(2L,"william","Antonio",LocalDate.of(1659, 12, 23));
		Empleado o = new Empleado(1L,"Alonzo","Selena",LocalDate.of(1956, 2, 23));
		Empleado u = new Empleado(3L,"Mercedez","Sulema",LocalDate.of(1989, 12, 22));

		
		manager.getTransaction().begin();
		manager.persist(e);
		manager.persist(a);
		manager.persist(i);
		manager.persist(o);
		manager.persist(u);

		manager.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	private static void imprimirTodo(){
		manager = emf.createEntityManager();
		List<Empleado> emps = (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay "+emps.size()+" empleados en el sistema.");
		for(Empleado emp:emps){
			System.out.println(emp.toString());
		}
	}

}
