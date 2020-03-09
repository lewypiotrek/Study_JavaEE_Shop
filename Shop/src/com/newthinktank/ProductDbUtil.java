package com.newthinktank;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.*;
public class ProductDbUtil {

	private DataSource dataSource;
	public ProductDbUtil(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	public List<Product> getProducts() throws Exception{
		List<Product> products = new ArrayList<>();
		
		Connection myCon = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myCon= dataSource.getConnection();
			String sql = "select * from product";
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				
				// GET PRODUCT DATA FROM DATABASE
				int idProduct = myRs.getInt("idProduct");
				String Name = myRs.getString("ProductName");
				String Price = myRs.getString("Price");
				String ShortDescription = myRs.getString("ShortDescription");
				String LongDescription = myRs.getString("LongDescription");
				String ImageUrl = myRs.getString("LongDescription");
				Boolean onSale = myRs.getBoolean("onSale");
				
				// CREATE TEMP PRODUCT
				Product tempProduct2 = new Product( idProduct, Name, ShortDescription, LongDescription, Price,  ImageUrl,  onSale);			
				products.add(tempProduct2);
			}
			
			return products;
		}
		finally {
			close(myCon,myStmt,myRs);
		}
		
	}
	
	public List<Product> GetProductsOnSale() throws Exception{
		List<Product> productsOnSale = new ArrayList<>();
		
		Connection myCon = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myCon= dataSource.getConnection();
			String sql = "call GetProductOnSale()";
			myStmt = myCon.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				
				// GET PRODUCT DATA FROM DATABASE
				int idProduct = myRs.getInt("idProduct");
				String Name = myRs.getString("ProductName");
				String Price = myRs.getString("Price");
				String ShortDescription = myRs.getString("ShortDescription");
				String LongDescription = myRs.getString("LongDescription");
				String ImageUrl = myRs.getString("LongDescription");
				Boolean onSale = myRs.getBoolean("onSale");
				
				// CREATE TEMP PRODUCT
				Product tempProduct2 = new Product( idProduct, Name, ShortDescription, LongDescription, Price,  ImageUrl,  onSale);			
				productsOnSale.add(tempProduct2);
			}
			
			return productsOnSale;
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
	}}
