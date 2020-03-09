<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>

<link rel="stylesheet" type="text/css" href="style/style.css">

<body>
<%
//allow access only if session exists
if(session.getAttribute("user") == null){
	response.sendRedirect("../ProductServlet");
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
			<li><a href='UserPages/UserHome.jsp'>Home</a></li>
			<li class="active"><a href='CartServlet'>Shopping Cart</a></li>
			<li><a href='UserServlet'>Products</a></li>
			<li><a href='Logout'>Logout</a></li>
			
		</ul>
	
	    
	    <div class="title">
		Your shopping card:
		</div>
	    
	 <table	class="Cart">	   
	   <tr>
	   		<th><h2>Product		</h2></th>
	   		<th><h2>Description	</h2></th>
	   		<th><h2>Price		</h2></th>
	   		<th></th>
	   </tr>
	   
	   <c:forEach var="tempProduct" items="${CARTS_LIST}">
	  
	  	  	<tr>
		 	 	<td class="Cart">${tempProduct.getName() }</td>
				<td class="Cart">${tempProduct.getShortDescription() }</td>
		  		<td class="Cart">${tempProduct.getPrice() }$ </td>
	  		</tr>
	  			  					 
	  	</c:forEach>
	  	
	  	<tr class="trCart">
	  		<th>
	  			<form action = "CartUpdateServlet" method = "post">
					<input class="oks" type = "submit" value = "Make order">
				</form>
	  		</th>
	  		
	  		<th>
	  			<form action = "CartClearServlet" method = "post">
					<input class="oks" type = "submit" value = "Clear Cart">
				</form>
	  		</th>
	  		
	  		<th>
	  			${tempProduct.getSum() }
	  		</th>
	  	</tr>
	 
	  </table>	
	  <br><br>



		
</header>
</body>
</html>