package hotel.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerDAO;
import mhotel.model.Address;
import mhotel.model.Customer;

/**
 * Servlet implementation class CustomerAddServlet
 */
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nume = request.getParameter("nume");
		String sex = request.getParameter("sex");
		String id = request.getParameter("id");
		String idType = request.getParameter("idType");
		
		String addCountry = request.getParameter("addr_country");
		String addCity = request.getParameter("addr_city");
		String addStreet = request.getParameter("addr_street");
		String addNumber = request.getParameter("addr_nbr");
		String addCP = request.getParameter("addr_cp");
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
				
				Address addr = new Address();
				addr.setCity(addCity);
				addr.setCountry(addCountry);
				addr.setNumber(addNumber);
				addr.setPostalCode(addCP);
				addr.setStreet(addStreet);
				customer.setAddress(addr);
				CustomerDAO customerDAO = new CustomerDAO(connection);
				customerDAO.insert(customer);
				connection.commit();
				response.sendRedirect(request.getContextPath() + "/customer/list");
			} finally {
				if(connection != null) {
					connection.close();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
