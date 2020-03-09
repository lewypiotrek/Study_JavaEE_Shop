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
		<%if (userName.equals("admin")){
			out.print("<li> <a href='AddProduct.jsp'>Add product</a></li>");
			} %>
			<li ><a href='UserPages/UserHome.jsp'>Home</a></li>
			<li ><a href='CartServlet'>Shopping Cart</a></li>
			<li class="active"><a href='#'>Products</a></li>
			<li><a href='../Logout'>Logout</a></li>			
		</ul>
	
		<div class="title">
		Best quality - Low prices !
		<br>
		<h3>Our offers:</h3>
	</div>
	
	
	
<form action="${pageContext.request.contextPath}/AddToCart" method="post">
<table class="table.Product">
<tbody>	   
<c:forEach var="tempProduct" items="${PRODUCT_LIST}">
	 	
	 	

	<tr><td>
		<div id="container">	
		
			<div class="product-details">
			
	
		<h1>${tempProduct.GetName() }</h1>
	
		<span class="hint-star star">
			<i class="fa fa-star" aria-hidden="true"></i>
			<i class="fa fa-star" aria-hidden="true"></i>
			<i class="fa fa-star" aria-hidden="true"></i>
			<i class="fa fa-star-half-o" aria-hidden="true"></i>
			<i class="fa fa-star-o" aria-hidden="true"></i>
		</span>
			
		
			<p class="information">${tempProduct.GetShortDescription() }</p>
	
			
	<div class="control">
		
	<!-- Start Button buying -->
		<button class="btn"  type="submit" name="button" value="${tempProduct.GetId() }">
	<!-- 		the Price -->
		 <span class="price">${tempProduct.GetPrice() } $</span>
	<!-- 		shopping cart icon-->
	   <span class="shopping-cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
	<!-- 		Buy Now / ADD to Cart-->
	  <span class="buy">Buy it!</span>
	 </button>
		
	</div>				
	</div>
		
	
	<div class="product-image">
		
		<img src="https://cdn.x-kom.pl/i/setup/images/prod/big/product-large,,2018/1/pr_2018_1_15_9_23_53_903_00.jpg" alt="Login to buy">
		
	<div class="info">
		<h2>The Description</h2>	
			${tempProduct.GetLongDescription() } $
	</div>
	</div>
</div>
</td></tr>

		 
</c:forEach>
</tbody>
</table> 	
</form>

		
</header>

</html>