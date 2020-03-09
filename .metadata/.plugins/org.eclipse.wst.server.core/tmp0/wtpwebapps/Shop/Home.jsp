<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome in our shop!</title>
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
			<li class="active"><a href='HomeServlet'>HOME</a></li>
			<li><a href='ProductServlet'>PRODUCTS</a></li>
			<li><a href='Contact.jsp'>CONTACT</a></li>
			<li><a href='index.jsp'>REGISTER</a></li>
			<li><a href='Login.jsp'>SIGN-IN</a></li>			
		</ul>
	
	<div class="title">
		Welcome in our shop!
		<br>
		<h3>Special offer for you:</h3>
	</div>   

<table>
<tbody>	   
<c:forEach var="tempProduct" items="${PRODUCT_LIST2}">
	 	
	 	

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
		
		<img src="https://cdn.x-kom.pl/i/setup/images/prod/big/product-large,,2017/7/pr_2017_7_19_10_18_26_229.jpg" alt="Login to buy">
		
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