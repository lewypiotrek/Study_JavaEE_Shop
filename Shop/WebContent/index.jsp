<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
<header>

		
		<ul>
			<li ><a href='HomeServlet'>HOME</a></li>
			<li><a href='ProductServlet'>PRODUCTS</a></li>
			<li><a href='Contact.jsp'>CONTACT</a></li>
			<li class="active"><a href='index.jsp'>REGISTER</a></li>
			<li><a href='Login.jsp'>SIGN-IN</a></li>	
		</ul>

			<div class="titleContact">
				Create your new account.
			</div>
<div class ="login">


	<form action = "ProcessInfo" method = "post">
	<label>First Name: </label>
	<input type = "text" name = "fname">
	<label>Last Name: </label>
	<input type = "text" name = "lname">
	<label>Phone: </label>
	<input type = "text" name = "phone">
	<label>Password: </label>
	<input type = "password" name = "password">
	<label>Email: </label>
	<input type = "text" name = "email">

<input type = "submit" value = "Register">

</form>
</div>
</header>
</body>
</html>