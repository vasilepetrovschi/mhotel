package hotel.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import mhotel.jpadao.CustomerJPADAO;
import mhotel.model.Customer;

@RequestScoped
public class CustomerServiceJPADAO {
	private static final Logger __logger = Logger.getLogger("hotel.business.CustomerServiceJPADAO");

	@Inject
	CustomerJPADAO mDao;

	public List<Customer> getAllCustomers() throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllCustomers entered");
		return mDao.findAll();
	}

	public Customer getCustomerById(long pId) throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllCustomers entered");
		return mDao.findOne(pId);

	}

	public Customer addCustomer(Customer pCustomer) throws Exception {
		mDao.create(pCustomer);
		return pCustomer;
	}
}
