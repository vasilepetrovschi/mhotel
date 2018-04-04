package httptest1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HttpMain {

	public static void main(String[] args) throws Exception {
		HttpServer server = HttpServer.create(new InetSocketAddress(8011), 0);
		server.createContext("/test", new MyHandler());
		server.createContext("/pufi", new MyHandlerPufi());

		server.setExecutor(null); // creates a default executor
		server.start();
	}

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><head><style type=\"text/css\">\r\n" + 
					"  h1 {\r\n" + 
					"    color: #FF0000;\r\n" + 
					"  }\r\n" + 
					"</style></head><body><H1>Sal'tare omenire</H1><hr>"
					+ "<H3>Buuuuuu</H3><hr>" + t.getRequestURI() + "</body></html>";
			
			t.getResponseHeaders().add("Content-Type", "text/html");
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
	
	static class MyHandlerPufi implements HttpHandler {
		@Override
		public void handle(HttpExchange t) throws IOException {
			String response = "<html><head><style type=\"text/css\">\r\n" + 
					"  h1 {\r\n" + 
					"    color: #FF0000;\r\n" + 
					"  }\r\n" + 
					"</style></head><body><H1>PUFI HANDLER</H1><hr>"
					+ "<H3>Buuuuuu</H3><hr>" + t.getRequestURI() + "</body></html>";
			
			t.getResponseHeaders().add("Content-Type", "text/html");
			t.sendResponseHeaders(200, response.length());
			OutputStream os = t.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}
