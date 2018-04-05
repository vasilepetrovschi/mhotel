package mhotel;

import java.io.IOException;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet Filter implementation class MyLoggingFilter
 */
public class MyLoggingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyLoggingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		System.out.println("Got request:" + httpRequest.getRequestURL());
		chain.doFilter(request, response);
		HttpServletResponse httpResponse = (HttpServletResponse)response;

		for(String hName : httpResponse.getHeaderNames()) {
			System.out.println(hName + ":" + httpResponse.getHeader(hName));
		}
		httpResponse.setHeader("PUFI", "GIGI");
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/HotelDB");
			System.out.println(ds);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Gata raspunsul :" + httpResponse.getHeader("Content-Type"));

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
