package hotel.customers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mhotel.model.Customer;

/**
 * Servlet implementation class ShowCustomers
 */
@WebServlet(urlPatterns="/customers/show/view")
public class ShowCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomers() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> customers = (List<Customer>)request.getAttribute("customers");
		
		
		String htmlStart = "<html><body><table border=1><tr><th>Nume</th><th>Sex</th><th>BI</th></tr>";
		String htmlEnd = "</table></body></html>";
		StringBuilder sb = new StringBuilder(htmlStart);
		for(Customer cust : customers) {
			sb.append("<tr><td>").append(cust.getName())
			 .append("</td><td>").append(cust.getSex())
			 .append("</td><td>").append(cust.getLegalId())
			 .append("</td></tr>");
		}
		sb.append(htmlEnd);
		response.getWriter().println(sb.toString());
	}

}
