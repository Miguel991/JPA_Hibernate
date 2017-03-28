package test;

import java.util.GregorianCalendar;
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
		
		
		//Bloque de transaccion
		manager.getTransaction().begin();
		Empleado e = manager.find(Empleado.class, 10L);
		e.setApellido("Mehert");
		e.setNombre("Gilberto");
		manager.getTransaction().commit();
		
		imprimirTodo();
		//close the manager when not in use
		manager.close();
	}
	private static void insertInicial() {
		Empleado e = new Empleado(10L,"Perez","Pepito",new GregorianCalendar(1979,6,6).getTime());
		Empleado i = new Empleado(9L,"Gates","Jose",new GregorianCalendar(1979,6,9).getTime());
		Empleado a = new Empleado(2L,"william","Antonio",new GregorianCalendar(1979,6,8).getTime());
		Empleado o = new Empleado(1L,"Alonzo","Selena",new GregorianCalendar(1979,6,7).getTime());
		Empleado u = new Empleado(3L,"Mercedez","Sulema",new GregorianCalendar(1979,6,5).getTime());

		
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
		List<Empleado> emps = (List<Empleado>)manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay "+emps.size()+" empleados en el sistema.");
		for(Empleado emp:emps){
			System.out.println(emp.toString());
		}
	}

}
