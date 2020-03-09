package com.newthinktank;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import javax.sql.DataSource;


  
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private CartDbUtil cartDbUtil;

@Resource(name="jdbc/projekt1")
private DataSource dataSource;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userName = null;

	    Cookie[] cookies = request.getCookies();
	    if(cookies !=null){
	    for(Cookie cookie : cookies){
	    	if(cookie.getName().equals("user")) userName = cookie.getValue();
	    }}
		 try {
			cartDbUtil = new CartDbUtil(dataSource,userName);
		 }
		catch(Exception exc) {
			throw new ServletException(exc);
		}
		try {
			
		
		listProducts(request,response);
		}
		catch (Exception exc) {throw new ServletException(exc);
		}
		}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		List<Cart> carts = cartDbUtil.getCarts();
		request.setAttribute("CARTS_LIST",carts);


		
		RequestDispatcher dispatcher=request.getRequestDispatcher("UserPages/Cart.jsp");
		dispatcher.forward(request, response);
	}




}
