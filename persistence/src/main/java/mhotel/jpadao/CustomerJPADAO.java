package mhotel.jpadao;

import javax.enterprise.context.RequestScoped;

import mhotel.model.Customer;

@RequestScoped
public class CustomerJPADAO extends AbstractJpaDAO<Customer> {
	public CustomerJPADAO() {
		super();
		setClazz(Customer.class);
	}
}
