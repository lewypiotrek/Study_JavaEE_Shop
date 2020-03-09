<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOG-IN</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("user") != null){
	response.sendRedirect("UserPages/Account.jsp");
}

%>
<header>


		<ul>
			<li><a href='HomeServlet'>HOME</a></li>
			<li><a href='ProductServlet'>PRODUCTS</a></li>
			<li><a href='Contact.jsp'>CONTACT</a></li>
			<li><a href='index.jsp'>REGISTER</a></li>
			<li class="active"><a href='Login.jsp'>SIGN-IN</a></li>		
		</ul>
	
			<div class="titleContact">
				<h3>Sign in</h3>
			<br>
				Don't have an account?<br>
				Create your new account in register tab.
			</div>
		
<div class ="login">
		<form action = "Logs" method = "post">
		<label>Email: </label>
		<input type = "text" name = "email"><br>
		<label>Password: </label>
		<input type = "password" name = "password"><br>
		<input type = "submit" value = "Login">
</form>

</div>
</header>


</body>
</html>