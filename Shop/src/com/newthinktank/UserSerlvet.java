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


  
@WebServlet("/UserServlet")
public class UserSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ProductDbUtil productDbUtil;

@Resource(name="jdbc/projekt1")
private DataSource dataSource;


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
			
		
		listProducts(request,response);
		}
		catch (Exception exc) {throw new ServletException(exc);
		}
		}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		
		
		List<Product> products = productDbUtil.getProducts();
		request.setAttribute("PRODUCT_LIST", products);


		
		RequestDispatcher dispatcher=request.getRequestDispatcher("UserPages/UserProductsPage.jsp");
		dispatcher.forward(request, response);
	}


}
