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
import javax.sql.DataSource;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
@Resource(name="jdbc/projekt1")
private DataSource dataSource;
private ProductDbUtil productDbUtil;
	
@Override
public void init() throws ServletException {
	super.init();

	 try {
		productDbUtil = new ProductDbUtil(dataSource);
	 }
	catch(Exception exc) {
		throw new ServletException(exc);
	}
	} 



protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
	listProductsOnSale(request,response);
	}
	catch (Exception exc) {throw new ServletException(exc);
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	private void listProductsOnSale(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		List<Product> products = productDbUtil.GetProductsOnSale();
		request.setAttribute("PRODUCT_LIST2", products);


		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
	}
}
