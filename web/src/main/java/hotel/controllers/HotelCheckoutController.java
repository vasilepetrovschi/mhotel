package hotel.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerRecordDAO;
import mhotel.model.CustomerRecord;

/**
 * Servlet implementation class HotelCheckoutController
 */
public class HotelCheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelCheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			List<CustomerRecord> customerRecords = null;
			try {
				connection = ds.getConnection();
				
				CustomerRecordDAO customerRecordDAO = new CustomerRecordDAO(connection);
				customerRecords = customerRecordDAO.getAllActiveCheckIns();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("/roomCheckOut.jsp");
			request.setAttribute("records", customerRecords);

			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
