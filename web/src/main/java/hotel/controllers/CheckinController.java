package hotel.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mhotel.DatasourceUtils;
import mhotel.dao.CustomerRecordDAO;
import mhotel.model.Hotel;

/**
 * Servlet implementation class CheckinController
 */
public class CheckinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckinController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 iau parametrii
		Long roomId = Long.parseLong(request.getParameter("room_id"));
		Long custId = Long.parseLong(request.getParameter("cust_id"));
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			List<Hotel> hotelList = null;
			try {
				connection = ds.getConnection();
				connection.setAutoCommit(false);
				CustomerRecordDAO crDAO = new CustomerRecordDAO(connection);
				crDAO.insert(custId, roomId);
				connection.commit();
			} finally {
				if (connection != null) {
					connection.close();
				}
			}
			response.sendRedirect(request.getContextPath() + "/customer/list");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
