<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (request.getUserPrincipal() != null) {
	%>
	Bine ai venit :
	<%=request.getUserPrincipal().getName()%>&nbsp;&nbsp;
	<a href='logout'>LOGOUT</a>
	<BR>

	<%
		}
	%>

	<div width="100%">
		<%
			if (request.isUserInRole("receptioner")) {
		%>
		<a href="customer/list">Clienti</a>&nbsp;&nbsp;&nbsp;&nbsp;

		<%
			}
		%>

		<%
			if (request.isUserInRole("manager_hotel")) {
		%>
		<a href="hotel/list">Hoteluri</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="hotel/checkout">Check out</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			}
		%>

		<a href="hotel/availableRooms">Raport camere libere</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="hotel/unavailableRooms">Raport camere ocupate</a>&nbsp;&nbsp;&nbsp;&nbsp;

	</div>
</body>
</html>