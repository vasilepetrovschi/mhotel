package hotel.customers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mhotel.model.Customer;

/**
 * Servlet implementation class ShowCustomersController
 */

@WebServlet(urlPatterns="/customers/show")
public class ShowCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer();
		customer.setName("Vasile");
		customer.setSex("M");
		customer.setLegalId("BIxxxx");
		customers.add(customer);
		customer = new Customer();
		customer.setName("Gheorghe");
		customer.setSex("M");
		customer.setLegalId("CI99999");
		customers.add(customer);
		customer = new Customer();
		customer.setName("Ioana");
		customer.setSex("F");
		customer.setLegalId("BI00000");
		customers.add(customer);
		//RequestDispatcher rd = request.getRequestDispatcher("show/view");
		RequestDispatcher rd = request.getRequestDispatcher("/showCustomers.jsp");

		request.setAttribute("customers", customers);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
