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
import javax.servlet.http.Cookie;

@WebServlet("/AddToCart")

public class AddToCart extends HttpServlet {	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      


        String userName = null;
    
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
        	if(cookie.getName().equals("user")) userName = cookie.getValue();
        }}
        
        String button = request.getParameter("button");
        updateDBp(userName,button);
        response.sendRedirect("CartServlet");
        
    }

protected void updateDBp(String email,String idProduct)
{
	Connection con;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Shop";
		String user = "root";
		String pw= "S*#rrQl*mA";
		con = DriverManager.getConnection(url,user,pw);
		Statement s= con.createStatement();
		String query= "call AddOrder('" + email +"','" + idProduct + "')";

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
