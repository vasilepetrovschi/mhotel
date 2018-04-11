<%@page import="mhotel.model.CustomerRecord"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<%
	    List<CustomerRecord> activeCheckins = (List<CustomerRecord>)request.getAttribute("records");
		
	  %>
	  
	  <%
	   if(activeCheckins.size() == 0) {
	  %>
	  	NO ACTIVE CHECKINS
	  <%
	   } else {
	  %>
	  ACTIVE CHECKINS
	  <ul>
	  <%
	    for(CustomerRecord cr : activeCheckins) {
	  %>
	  	<li>paturi:<%= cr.getRoom().getNumberOfBeds() %>,camera:
	  	<%= cr.getRoom().getNumber() %>, etaj: <%= cr.getRoom().getFloor() %>,
	  	client: <%= cr.getCustomer().getName() %>
	  <%
	    }
	  %>
	  </ul>
	  
	  <%
	   }
	  %>
	  	
		</div>
</body>
</html>