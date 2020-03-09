package com.newthinktank;
import java.io.Serializable;

public class Product implements Serializable{

private static final long serialVersionUID = 1L;

private int idProduct;
private String Name;
private String ShortDescription;
private String LongDescription;
private String Price;
private String ImageUrl;
private boolean onSale;

public Product()
{
	this.idProduct = 0;
	this.Name = "null";
	this.ShortDescription = "null";
	this.LongDescription = "null";
	this.Price = "0.0";
	this.ImageUrl = "null";
	this.onSale = false;	
}

public Product(int id, String Name, String ShortDescription, String LongDescription,String price, String ImageUrl, boolean onSale) 
{	
	this.idProduct = id;
	this.Name = Name;
	this.ShortDescription = ShortDescription;
	this.LongDescription = LongDescription;
	this.Price = price;
	this.ImageUrl = ImageUrl;
	this.onSale = onSale;	
}

public Product(String Name, String ShortDescription, String LongDescription,String price, String ImageUrl) 
{	
	this.Name = Name;
	this.ShortDescription = ShortDescription;
	this.LongDescription = LongDescription;
	this.Price = price;
	this.ImageUrl = ImageUrl;
	this.onSale = false;
}


public String GetName() {
	return Name;
}
public void SetName(String Name) {
	this.Name = Name;
}
public void SetOnSale(boolean sale) {
	this.onSale = sale;
}
public String GetShortDescription() {
	return ShortDescription;
}
public String GetLongDescription() {
	return LongDescription;
}
public void SetShortDescription(String Description) {
	this.ShortDescription = Description;
}
public void SetLongDescription(String Description) {
	this.LongDescription = Description;
}
public String GetPrice() {
	return Price;
}
public void SetPrice(String Price) {
	this.Price = Price;
}

public String GetImage() {
	return this.ImageUrl;
}

public int GetId() {
	return idProduct;
}

public void SetId(int id) {
	this.idProduct = id;
}

/*
@Override
public String toString() {
	return "Product [id=" + idProduct + ", pName=" + Name + ", pDescription=" + ShortDescription
			+ ", pPrise=" + Price + "]";
}
*/
}