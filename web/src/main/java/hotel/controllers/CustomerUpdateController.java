package hotel.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerDAO;
import mhotel.dao.CustomerRecordDAO;
import mhotel.dao.RoomDAO;
import mhotel.model.Address;
import mhotel.model.Customer;
import mhotel.model.CustomerRecord;
import mhotel.model.Room;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/customer/update")
public class CustomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> errors = new ArrayList<String>();
		
		Long customerId = Long.parseLong(request.getParameter("customer_id"));
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			Customer customer = null;
			try {
				connection = ds.getConnection();
				CustomerDAO customerDAO = new CustomerDAO(connection);
				customer = customerDAO.loadById(customerId);
			} finally {
				if (connection != null) {
					connection.close();
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("/customerUpdate.jsp");
			request.setAttribute("customer", customer);
			request.setAttribute("errors", errors);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Long customerId = Long.parseLong(request.getParameter("cust_id"));
		String nume = request.getParameter("nume");
		String sex = request.getParameter("sex");
		String id = request.getParameter("id");
		String idType = request.getParameter("idType");
		String birthday = request.getParameter("bday");

		Long addId = Long.parseLong(request.getParameter("addr_id"));
		String addCountry = request.getParameter("addr_country");
		String addCity = request.getParameter("addr_city");
		String addStreet = request.getParameter("addr_street");
		String addNumber = request.getParameter("addr_nbr");
		String addCP = request.getParameter("addr_cp");

		ArrayList<String> errors = new ArrayList<String>();
		
		
			try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			try {
				connection = ds.getConnection();
				connection.setAutoCommit(false);
				Customer customer = new Customer();
				customer.setId(customerId);
				customer.setName(nume);
				customer.setSex(sex);
				customer.setLegalId(id);
				customer.setLegalIdType(idType);
				customer.setBirthday(birthday);

				Address addr = new Address();
				addr.setId(addId);
				addr.setCity(addCity);
				addr.setCountry(addCountry);
				addr.setNumber(addNumber);
				addr.setPostalCode(addCP);
				addr.setStreet(addStreet);
				customer.setAddress(addr);
				Set<ConstraintViolation<Customer>> customerViolations = validator.validate(customer);
				Set<ConstraintViolation<Address>> addressViolations = validator.validate(addr);
				if (customerViolations.size() > 0 || addressViolations.size() > 0) {
					for (ConstraintViolation<Customer> custViolation : customerViolations) {
						String error = custViolation.getMessage();
						errors.add(error);
					}
					for (ConstraintViolation<Address> addrViolation : addressViolations) {
						String error = addrViolation.getMessage();
						errors.add(error);
					}
					RequestDispatcher rd = request.getRequestDispatcher("/customerUpdate.jsp");
					request.setAttribute("customer", customer);
					request.setAttribute("errors", errors);
					rd.forward(request, response);
				} else {
					CustomerDAO customerDAO = new CustomerDAO(connection);
					customerDAO.update(customer);
					connection.commit();
					response.sendRedirect(request.getContextPath() + "/customer/list");
				}

			} finally {
				if (connection != null) {
					connection.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	
	}

}
