package hotel.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.business.AddressServiceJPADAO;
import hotel.inj.Logged;
import mhotel.model.Address;

/**
 * Servlet implementation class AddressListController
 */
//@WebServlet("/customer/list")
public class AddressListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AddressServiceJPADAO mAddressService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    @Logged
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {

			List<Address> addressList = mAddressService.getAllAddress();

			RequestDispatcher rd = request.getRequestDispatcher("/customerList.jsp");
			request.setAttribute("addresses", addressList);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	

}
