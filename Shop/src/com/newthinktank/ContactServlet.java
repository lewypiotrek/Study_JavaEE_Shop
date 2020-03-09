package com.newthinktank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		String message= request.getParameter("message");

		
		SendMessage(email,phone,message);
		
		Contact con= new Contact(message,email,phone);
		
		
		request.setAttribute("contact",con);
		response.sendRedirect("Contact.jsp");
	}

	
	public void SendMessage(String email,String phone,String message){
		
		{
			Connection con;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/Shop";
				String user = "root";
				String pw= "S*#rrQl*mA";
				con = DriverManager.getConnection(url,user,pw);
				Statement s= con.createStatement();
				String sql = "Insert into Contact (Message,email,phone) values ('" +  message + "','" + email + "','" + phone + "')";

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
