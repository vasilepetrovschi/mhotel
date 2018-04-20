package mhotel;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mhotel.model.Car;
import mhotel.model.TechnicalInspection;


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
        TechnicalInspection ti = new TechnicalInspection();
        ti.setCar(car);
        ti.setInspectionDate(new Date());
        ti.setLocation("AICI");
        ti.setInspectionReport("BUN");
        em.persist(ti);
        car.getInspections().add(ti);
        ti = new TechnicalInspection();
        ti.setCar(car);
        ti.setInspectionDate(new Date());
        ti.setLocation("ACOLO");
        ti.setInspectionReport("RAU");
        em.persist(ti);
        car.getInspections().add(ti);
        
        System.out.println("Before commit:" + car);
        em.getTransaction().commit();
        System.out.println("After commit:" + car);
        Long id = car.getId();
        em.clear();
        Car car1 = em.find(Car.class, id);

        System.out.println("Instanta proaspat incarcata din DB:" + car1);
        em.close();		


	}

}
