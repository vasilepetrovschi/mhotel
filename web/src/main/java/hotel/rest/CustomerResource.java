package hotel.rest;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerDAO;
import mhotel.model.Customer;

@Path("/customers")
public class CustomerResource {
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Customer> getAllCustomers() throws Exception {
		try {
			DataSource ds = DatasourceUtils.getDataSource();
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
			e.printStackTrace();
			throw e;
		}
	}

	@GET
	@Path("/all/{cid}")
	public Customer getCustomerById(@PathParam("cid") long pId) throws Exception {
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
			e.printStackTrace();
			throw e;
		}
	}
	
	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
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
			e.printStackTrace();
			throw e;
		}
	}
}
