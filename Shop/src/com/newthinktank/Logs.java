package com.newthinktank;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class Logs
 */
@WebServlet("/Logs")
public class Logs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  boolean status ;
	public static String wyn;




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String id= getId(email);
		
		boolean check=checkPass(email,password);
			
	if (check==true) {
		HttpSession userSession = request.getSession();
		userSession.setAttribute("user", email);
		userSession.setAttribute("id", id);
		userSession.setMaxInactiveInterval(30*60);

		Cookie userName = new Cookie("user",email);
		Cookie idUser=new Cookie("id",id);
		idUser.setMaxAge(30*60);
		userName.setMaxAge(30*60);
		response.addCookie(userName);
		response.sendRedirect("UserPages/UserHome.jsp");
		
		}else {
			
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('Incorrect login or password. Try again')</script>");
		rd.include(request, response);
		}
	}

	protected boolean checkPass(String email,String password)
	{
		
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/Shop";
			String user = "root";
			String pw= "S*#rrQl*mA";
			con = DriverManager.getConnection(url,user,pw);
			Statement s= con.createStatement();
			String query = "select UserPassword from Customer where Email='"+email+"'";
			
			
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {wyn=rs.getString("UserPassword");}
			
			if(wyn.equals(password)) {
				status=true;
			}else {
				status=false;
				}
			
			rs.close();
			s.close();
			con.close();
			}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return status;	
		
	}
	
	protected String getId (String email) {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/projekt1";
			String user = "root";
			String pw= "myroot";
			con = DriverManager.getConnection(url,user,pw);
			Statement s= con.createStatement();
			String query = "select idCustomer from Customer where Email='"+email+"'";
			
			
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {wyn=rs.getString("cust_id");}
			
			rs.close();
			s.close();
			con.close();
			}
		
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		return wyn;
	}
}

