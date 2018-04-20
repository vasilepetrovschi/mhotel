package mhotel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mhotel.model.Car;


public class MainJPA {
	private static final String PERSISTENCE_UNIT_NAME = "hotel";
    private static EntityManagerFactory factory;
    
    
	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        TypedQuery<Car> q = em.createQuery("select t from mhotel.model.Car t",Car.class);
        List<Car> carList = q.getResultList();
        for (Car car : carList) {
            System.out.println(car);
        }
        System.out.println("Size: " + carList.size());

        // create new todo
        em.getTransaction().begin();
        Car car = new Car();
        car.setColor("BLACK");
        car.setMaker("GM");
        car.setMileage(100);
        car.setModel("CORVETTE");
        car.setYear(1998);
        em.persist(car);
        System.out.println("Before commit:" + car);
        em.getTransaction().commit();
        System.out.println("After commit:" + car);

        em.close();		
	}

}
