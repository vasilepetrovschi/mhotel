<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login error</title>
<style type="text/css">
input[type=text], input[type=password] {
	display: block;
}
</style>
</head>
<body>
	<h1>Try again</h1>

	<p>The information you provided was incorrect, please check the
		credentials and try again.</p>

	<form action="j_security_check" method="post" name="loginForm">
		<label for="user">User name:</label> 
		<input id="user" type="text" name="j_username" size="20">
		<label for="password">Password</label> 
		<input id="password" type="password" name="j_password" size="20">

		<input type="submit" value="Login">
	</form>
</body>
</html>