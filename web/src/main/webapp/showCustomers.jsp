<%@page import="mhotel.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--
  https://www.tutorialspoint.com/jsp/index.htm
 --%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <style type="text/css">
    td {
      font-weight: bold;
      color: magenta;
    }
  </style>
  <script type="text/javascript">
    function buuu() {
		alert('buuuu');
	}
  </script>
</head>
<body>
	<%
		List<Customer> customers = (List<Customer>) request.getAttribute("customers");
	%>
	<h1>Lista clienti de afisat</h1>
	<table border="1" >
		<tr>
			<td>Nume</td>
			<td>Sex</td>
			<td>ID</td>
		</tr>
		<%
			for (Customer customer : customers) {
		%>
		<tr>
			<td><%=customer.getName()%></td>
			<td><%=customer.getSex()%></td>
			<td><%=customer.getLegalId()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<button onclick="buuu()">BUUU</button>
</body>
</html>