package hotel.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import hotel.business.CustomerService;
import mhotel.model.Customer;

@Path("/customers")
public class CustomerResource {
	private static final Logger __logger = Logger.getLogger("hotel.rest.CustomerResource");

	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Customer> getAllCustomers() throws Exception {
		if (__logger.isLoggable(Level.INFO))
			__logger.log(Level.INFO, "getAllCustomers entered");
		CustomerService cs = new CustomerService();
		return cs.getAllCustomers();
	}

	@GET
	@Path("/all/{cid}")
	public Customer getCustomerById(@PathParam("cid") long pId) throws Exception {
		return new CustomerService().getCustomerById(pId);
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	public Customer addCustomer(Customer pCustomer) throws Exception {
		return new CustomerService().addCustomer(pCustomer);
	}
	
	private void bau() {
		System.out.println("Bau");
	}
}
