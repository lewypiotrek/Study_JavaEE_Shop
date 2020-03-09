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


  
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ProductDbUtil productDbUtil;
private ProductDbUtil productDbUtil2;

@Resource(name="jdbc/projekt1")
private DataSource dataSource;


	@Override
public void init() throws ServletException {
	super.init();

	 try {
		productDbUtil = new ProductDbUtil(dataSource);
		productDbUtil2 = new ProductDbUtil(dataSource);
	 }
	catch(Exception exc) {
		throw new ServletException(exc);
	}
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		
		listProducts(request,response);
		listProductsOnSale(request,response);
		}
		catch (Exception exc) {throw new ServletException(exc);
		}
		}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		List<Product> products = productDbUtil.getProducts();
		request.setAttribute("PRODUCT_LIST", products);


		
		RequestDispatcher dispatcher=request.getRequestDispatcher("ProductsPage.jsp");
		dispatcher.forward(request, response);
	}

	
	private void listProductsOnSale(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		List<Product> products = productDbUtil2.GetProductsOnSale();
		request.setAttribute("PRODUCT_LIST2", products);


		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Home.jsp");
		dispatcher.forward(request, response);
	}




}
