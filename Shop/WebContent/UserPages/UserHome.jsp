<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome in our shop!</title>
<link rel="stylesheet" type="text/css" href="../style/style.css">
<style>


</style>

</head>
<body>
<%
//allow access only if session exists
if(session.getAttribute("user") == null){
	response.sendRedirect("../Login.jsp");
}
if(session.getAttribute("user") == "admin"){
	response.sendRedirect("../admin.jsp");
}
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
%>
<header>

  
		<ul>
		<%if (userName.equals("admin")){
			out.print("<li> <a href='AddProduct.jsp'>Add product</a></li>");
			} %>
			<li class="active"><a href='#'>Home</a></li>
			<li><a href='../UserServlet'>Products</a></li>
			<li><a href='../Logout'>Logout</a></li>
			
		</ul>
	
	<div class="title">
		<h2>Hi <%=userName %></h2>
		News for you:
	</div>
	<br>
	<br>
	<div class="textTitle">
	We are offering all Doe customers a chance to save up to 45% on computer software this Saturday, March 15, from 8:00 a.m. to 9:00 p.m., at our Main Street store.<br>
	Receive discounts on all the latest software packages by bringing canned food for the homeless. The more food you bring, the more you save. Plan to be there!
	
 	</div>
 	
 	

</header>
</body>	
</html>