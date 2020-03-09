package com.newthinktank;

import java.io.Serializable;

public class Cart implements Serializable{

private static final long serialVersionUID = 1L;
private int id;
private String email;
private int idProduct;
private double Price;
private String ProductName;
private String ShortDescription;

public Cart()
{

	this.setEmail("");
	this.setIdProduct(0);
	this.setPrice(0);
	this.setDescription("");
	this.setName("");
	
}


public Cart(int id, String email, int idProduct) {
	
	this.id = id;
	this.email = email;
	this.idProduct = idProduct;

}
public Cart(String Name,String ShortDescription,double Price) {
	
	this.Price=Price;
	this.ShortDescription=ShortDescription;
	this.ProductName=Name;

}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public double getPrice() {
	return Price;
}

public void setPrice(double Price) {
	this.Price = Price;
}


public int getIdProduct() {
	return idProduct;
}


public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}


public String getName() {
	return ProductName;
}


public void setName(String name) {
	ProductName = name;
}


public String getShortDescription() {
	return ShortDescription;
}


public void setDescription(String description) {
	ShortDescription = description;
}

}