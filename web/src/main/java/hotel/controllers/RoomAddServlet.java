package hotel.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import mhotel.DatasourceUtils;
import mhotel.dao.HotelDAO;
import mhotel.dao.RoomDAO;
import mhotel.model.Address;
import mhotel.model.Hotel;
import mhotel.model.Room;

/**
 * Servlet implementation class RoomAddServlet
 */
public class RoomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hotelId = request.getParameter("hotel_id");
		String numar = request.getParameter("nr_camera");
		String etaj = request.getParameter("etaj");
		String paturi = request.getParameter("paturi");
		try {
			DataSource ds = DatasourceUtils.getDataSource();
			Connection connection = null;
			try {
				connection = ds.getConnection();
				connection.setAutoCommit(false);
				HotelDAO hotelDAO = new HotelDAO(connection);
				Hotel hotel = hotelDAO.loadById(Long.parseLong(hotelId));
				Room room = new Room();
				room.setNumber(numar);
				room.setFloor(Integer.parseInt(etaj));
				room.setNumberOfBeds(Integer.parseInt(paturi));
				room.setAvailableForRent(true);
				room.setHotel(hotel);
				
				RoomDAO roomDAO = new RoomDAO(connection);
				roomDAO.insert(room);
				connection.commit();
				response.sendRedirect(request.getContextPath() + "/hotel/list");
			} finally {
				if(connection != null) {
					connection.close();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	}

}
