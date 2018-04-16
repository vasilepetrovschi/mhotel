package hotel.business;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerDAO;
import mhotel.model.Customer;

public class CustomerService {
	private static final Logger __logger = Logger.getLogger("hotel.business.CustomerService");

	public List<Customer> getAllCustomers() throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllCustomers entered");
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			if (__logger.isLoggable(Level.FINE))
				__logger.log(Level.FINE, "got datasource" + ds.toString());
			Connection connection = null;
			List<Customer> customerList = null;
			try {
				connection = ds.getConnection();
				CustomerDAO customerDAO = new CustomerDAO(connection);
				customerList = customerDAO.listAll();
				return customerList;
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			__logger.log(Level.WARNING, "getAllCustomers", e);
			throw e;
		}
	}

	public Customer getCustomerById(long pId) throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllCustomers entered");
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			try {
				connection = ds.getConnection();
				CustomerDAO customerDAO = new CustomerDAO(connection);
				return customerDAO.loadById(pId);
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			__logger.log(Level.WARNING, "getCustomerById", e);
			throw e;
		}
	}

	public Customer addCustomer(Customer pCustomer) throws Exception {
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			try {
				connection = ds.getConnection();
				CustomerDAO customerDAO = new CustomerDAO(connection);
				return customerDAO.insert(pCustomer);
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			__logger.log(Level.WARNING, "addCustomer", e);
			throw e;
		}
	}
}
