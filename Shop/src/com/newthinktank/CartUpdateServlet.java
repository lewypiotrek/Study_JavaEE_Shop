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
@WebServlet("/CartUpdateServlet")
public class CartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdateServlet() {
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
			String sql = "update Cart set onOrder=1 where email='"+ Username + "' and onOrder=0";

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
