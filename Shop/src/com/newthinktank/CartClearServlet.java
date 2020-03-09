package com.newthinktank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
/**
 * Servlet implementation class ProcessInfo
 */
@WebServlet("/CartClearServlet")
public class CartClearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartClearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	    String userName = null;

	    Cookie[] cookies = request.getCookies();
	    if(cookies !=null){
	    for(Cookie cookie : cookies){
	    	if(cookie.getName().equals("user")) userName = cookie.getValue();}}
	
			UpdateCart(userName);

			response.sendRedirect("CartServlet");
	}
public void UpdateCart(String Username){
		
	{
		Connection con;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Shop";
			String user = "root";
			String pw= "S*#rrQl*mA";
			con = DriverManager.getConnection(url,user,pw);
			Statement s= con.createStatement();
			String sql = "delete from Cart where email='"+ Username + "' and onOrder=0";

			s.executeUpdate(sql);
			
			
			s.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	}

}
