package mhotel.jpadao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	private static final String PERSISTENCE_UNIT_NAME = "hotel";

	EntityManagerFactory emf;
	
	///@PostConstruct
	//public void init() {
	//	emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	//}
	
	@RequestScoped
	@Produces
	public EntityManager getEM() {
		if(emf == null) {
			synchronized (this) {
				if(emf == null) {
					emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
				}
			}
		}
		return emf.createEntityManager();
	}

}
