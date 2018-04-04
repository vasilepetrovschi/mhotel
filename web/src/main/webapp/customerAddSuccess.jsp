<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>CUSTOMER SUCCESUFLLY ADDED</h1>
  <br> Nume adaugat : <%= request.getAttribute("name") %>
    <br> Varsta adaugata : <%= request.getAttribute("age") %>
  
</body>
</html>