<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
<style>


</style>

</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("user") != null){
	response.sendRedirect("UserPages/UserHome.jsp");
}

%>
<header>

  
		<ul>
			<li ><a href='HomeServlet'>HOME</a></li>
			<li><a href='ProductServlet'>PRODUCTS</a></li>
			<li class="active"><a href='Contact.jsp'>CONTACT</a></li>
			<li><a href='index.jsp'>REGISTER</a></li>
			<li><a href='Login.jsp'>SIGN-IN</a></li>	
		</ul>
	
	<div class="titleContact">
		Do you have a questions? Send message to us! 
		<br>Our specialist will contact with you as soon as possibile! 
	</div>
 	
 	<div class ="Contact">
 	
	 <form action = "ContactServlet" method = "post">
		<label>Email: </label><br>
		<input class="inputContact" type = "text" name = "email"><br>
		<label>Phone: </label><br>
		<input class="inputContact" type = "text" name = "phone"><br>
		<label>Message: </label><br>
		<textarea id="message" name ="message" rows="10" cols="90"></textarea><br>
		<input class="inputContact" type = "submit" value = "Send to us">
	</form>
	
	</div>
	

</header>
</body>	
</html>