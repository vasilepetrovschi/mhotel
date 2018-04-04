package mhotel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("<B><I>HTTP METHOD:").append(request.getMethod()).append("</I></B><BR>");
		sb.append("<B><I>HTTP QUERY PARAMS</I></B><BR>");
		Map<String, String[]> qpMap = request.getParameterMap();
		for(Map.Entry<String, String[]> e : qpMap.entrySet()) {
			sb.append("<B><I>").append(e.getKey())
			.append("=").append(e.getValue()[0])
			.append("</I></B><BR>");

		}
		Enumeration<String> headerNames = request.getHeaderNames();
		sb.append("<I>HTTP REQUEST HEADERS</I><BR>");
		while(headerNames.hasMoreElements()) {
			String hName = headerNames.nextElement();
			sb.append("<I>").append(hName)
			.append("=").append(request.getHeader(hName))
			.append("</I><BR>");
		}
		sb.append("<a href='customers/show'>Customers</a>");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>GET HERE I AM Served at: " + request.getContextPath());
		pw.println("<div>" + sb.toString() + "</div></body></html>");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("POST HERE I AM Served at: " + request.getContextPath());
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		pw.println("PUT HERE I AM Served at: " + request.getContextPath());
	}

}
