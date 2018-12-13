package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

 
@Entity
@Table
public class UserDetail 
{


String Username;
String Password;
boolean Enabled;
String Role;

String CustomerName;
String Mobileno;
String Emailid;
String Address;
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public boolean isEnabled() {
	return Enabled;
}
public void setEnabled(boolean enabled) {
	Enabled = enabled;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getCustomerName() {
	return CustomerName;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public String getMobileno() {
	return Mobileno;
}
public void setMobileno(String mobileno) {
	Mobileno = mobileno;
}
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address= address;
}

}
