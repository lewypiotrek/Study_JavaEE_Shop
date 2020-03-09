package com.newthinktank;
import java.io.Serializable;

public class Customer implements Serializable {

private static final long serialVersionUID = 1L;
private String fName;
private String lName;
private String phone;
private String email;
private String UserPassword;


public Customer()
{
	this.fName="";
	this.lName="";
	this.phone="";
	this.email="";
	this.UserPassword="";
}
public Customer(String fName,String lName , String phone,String password,String email)
{
	this.setfName(fName);
	this.setlName(lName);
	this.setPhone(phone);
	this.setEmail(email);
	this.setPassword(UserPassword);
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return UserPassword;
}
public void setPassword(String password) {
	this.UserPassword = password;
}

}
