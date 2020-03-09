<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
<link rel="stylesheet" type="text/css" href="../style/style.css">
</head>
<body>
<header>

		
		<ul>
			<li><a href='UserHome.jsp'>Home</a></li>
			<li ><a href='CartServlet'>Shopping Cart</a></li>	
			<li ><a href='../UserServlet'>Products</a></li>
			<li><a href='../Logout'>Logout</a></li>
		</ul>

<div class ="login">

	<form action = "../AddProduct" method = "post">
	
	<label>Product Name: </label>
	<input type = "text" name = "pName">
	
	<label>Short Description: </label>
	<input type = "text" name = "pDescription">
	
	<label>Long Description: </label>
	<input type = "text" name = "plDescription">
	
	<label>Price: </label>
	<input type = "text" name = "Price">
	
	<label>Image URL: </label>
	<input type = "text" name = "ImageUrl">


<input type = "submit" value = "Add product">
</form>


</div>
</header>
</body>
</html>