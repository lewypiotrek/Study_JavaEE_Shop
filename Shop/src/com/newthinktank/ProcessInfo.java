package com.newthinktank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
/**
 * Servlet implementation class ProcessInfo
 */
@WebServlet("/ProcessInfo")
public class ProcessInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessInfo() {
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
		String fName= request.getParameter("fname");
		String lName= request.getParameter("lname");
		String phone= request.getParameter("phone");
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		
		updateDB(fName,lName,phone,password,email);
		
		Customer cust= new Customer(fName,lName,phone,password,email);
		
		request.setAttribute("cust",cust);
		HttpSession userSession = request.getSession();
		userSession.setAttribute("user", email);
		userSession.setMaxInactiveInterval(30*60);
		Cookie userName = new Cookie("user",email);
		userName.setMaxAge(30*60);
		response.addCookie(userName);
		response.sendRedirect("UserPages/UserHome.jsp");
	}
	
	
	
	protected void updateDB(String fName,String lName,String phone,String password,String email)
	{
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Shop";
			String user = "root";
			String pw= "S*#rrQl*mA";
			con = DriverManager.getConnection(url,user,pw);
			Statement s= con.createStatement();
			String query= "call AddCustomer('" + fName + "','" + lName + "','" + phone + "','" + email + "','" + password +"');";
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
