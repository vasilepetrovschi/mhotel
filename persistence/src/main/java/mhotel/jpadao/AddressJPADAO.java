package mhotel.jpadao;

import javax.enterprise.context.RequestScoped;

import mhotel.model.Address;

@RequestScoped
public class AddressJPADAO extends AbstractJpaDAO<Address>{

	public AddressJPADAO() {
		super();
		setClazz(Address.class);
	}
}
