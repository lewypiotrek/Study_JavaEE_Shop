package com.newthinktank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class ProcessInfo
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String Name= request.getParameter("pName");
		String ShortDescription= request.getParameter("pDescription");
		String LongDescription= request.getParameter("plDescription");
		String price= request.getParameter("Price");
		String ImageUrl= request.getParameter("ImageUrl");
		
		updateDBp(Name,ShortDescription,LongDescription,price,ImageUrl);
		
		Product prod= new Product( Name, ShortDescription, LongDescription, price, ImageUrl);
		
		request.setAttribute("product",prod);
		response.sendRedirect("UserPages/UserHome.jsp");
	}
	protected void updateDBp(String Name, String ShortDescription, String LongDescription,String price, String ImageUrl)
	{
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Shop";
			String user = "root";
			String pw= "S*#rrQl*mA";
			con = DriverManager.getConnection(url,user,pw);
			Statement s= con.createStatement();
			String query="call AddProduct('" + Name + "','" + price + "','" + ShortDescription + "','" + LongDescription + "','" + ImageUrl + "')";
			s.executeUpdate(query);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
