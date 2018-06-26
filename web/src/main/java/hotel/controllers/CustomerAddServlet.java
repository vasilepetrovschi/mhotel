package hotel.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import org.json.JSONArray;
import org.json.JSONObject;

import hotel.business.CustomerServiceJPADAO;
import hotel.inj.Logged;
import mhotel.DatasourceUtils;
import mhotel.dao.CustomerDAO;
import mhotel.jpadao.CustomerJPADAO;
import mhotel.model.Address;
import mhotel.model.Customer;

/**
 * Servlet implementation class CustomerAddServlet
 */
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

//	@Inject
//	private CustomerServiceJPADAO mCustomerService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Logged
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> errors = new ArrayList<String>();

		RequestDispatcher rd = request.getRequestDispatcher("/customerAdd.jsp");
		request.setAttribute("errors", errors);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nume = request.getParameter("nume");
		String sex = request.getParameter("sex");
		String id = request.getParameter("id");
		String idType = request.getParameter("idType");
		String birthday = request.getParameter("bday");

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
				customer.setName(nume);
				customer.setSex(sex);
				customer.setLegalId(id);
				customer.setLegalIdType(idType);
				customer.setBirthday(birthday);

				Address addr = new Address();
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
					RequestDispatcher rd = request.getRequestDispatcher("/customerAdd.jsp");
					request.setAttribute("errors", errors);
					rd.forward(request, response);
				} else {
					CustomerDAO customerDAO = new CustomerDAO(connection);
					customerDAO.insert(customer);
//					mCustomerService.addCustomer(customer);
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
