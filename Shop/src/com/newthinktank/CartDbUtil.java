package com.newthinktank;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.*;
public class CartDbUtil {

	private DataSource dataSource;
	private String email;
	public CartDbUtil(DataSource theDataSource,String theEmail) {
		dataSource=theDataSource;
		email=theEmail;


	}
	public List<Cart> getCarts() throws Exception{
		List<Cart> carts = new ArrayList<>();
		
		Connection myCon = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myCon= dataSource.getConnection();
			
			String query= "call GetOrder('" + email + "');";

			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery(query);

			double Price=0;
			String Name="";
			String Description="";
			
		
			while(myRs.next()) {
				Name=myRs.getString("ProductName");
				Description=myRs.getString("ShortDescription");
				Price=myRs.getDouble("Price");
				
				Cart tempProduct = new Cart(Name,Description,Price);
				
				carts.add(tempProduct);
			}

			return carts;
		}
		finally {
			close(myCon,myStmt,myRs);
		}
		
	}
	
	private void close(Connection myCon, Statement myStmt, ResultSet myRs) {
		
		try {
			if(myRs!=null) {
				myRs.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(myCon!=null) {
				myCon.close();
			}
			 
		}
	catch (Exception exc)
		{
		exc.printStackTrace();
		}
	}
}
