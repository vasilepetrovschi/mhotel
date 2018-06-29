package hotel.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mhotel.model.Address;
import mhotel.model.Customer;

/**
 * Servlet implementation class AvailableRoomsController
 */
//@WebServlet("/availableRooms")
public class AvailableRoomsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableRoomsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			//List<Customer> customerList = mCustomerService.getAllCustomers();
			//List<Address> addressList = mAddressService.getAllAddress();

			RequestDispatcher rd = request.getRequestDispatcher("/availableRooms.jsp");
			//request.setAttribute("customers", customerList);
			//request.setAttribute("addresses", addressList);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//this line works only if not exist RequestDispatcher or if RequestDispatcher exist, it work only with the include(request, response) method
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
