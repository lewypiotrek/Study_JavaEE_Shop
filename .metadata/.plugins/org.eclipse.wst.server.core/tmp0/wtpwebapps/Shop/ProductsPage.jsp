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
if(session.getAttribute("user") != null){
	response.sendRedirect("UserServlet");
}%>
<header>


		<ul>
			<li><a href='HomeServlet'>HOME</a></li>
			<li class="active"><a href='ProductServlet'>PRODUCTS</a></li>
			<li><a href='Contact.jsp'>CONTACT</a></li>
			<li><a href='index.jsp'>REGISTER</a></li>
			<li><a href='Login.jsp'>SIGN-IN</a></li>
			
		</ul>
	
		<div class="title">
		Best quality - Low prices !
		<br>
		<h3>Our offers:</h3>
	</div>

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
		<button class="btn">
	<!-- 		the Price -->
		 <span class="price">${tempProduct.GetPrice() } $</span>
	<!-- 		shopping cart icon-->
	   <span class="shopping-cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></span>
	<!-- 		Buy Now / ADD to Cart-->
	  <span class="buy">Login to buy this item</span>
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
	

		
</header>
</body>
</html>