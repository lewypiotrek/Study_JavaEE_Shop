package com.newthinktank;
import java.io.Serializable;

public class Contact implements Serializable{

private static final long serialVersionUID = 1L;

private String message;
private String email;
private String phone;




public Contact(String Message, String email, String phone)
{

	this.message = Message;
	this.email = email;
	this.phone = phone;
}


}