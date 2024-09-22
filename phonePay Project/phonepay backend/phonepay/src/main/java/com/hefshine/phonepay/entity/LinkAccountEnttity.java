package com.hefshine.phonepay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity @Data
//linkbankaccount
public class LinkAccountEnttity 
{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
int accountno;
String ifscno;
Double balance;
long mobile;
String name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAccountno() {
	return accountno;
}
public void setAccountno(int accountno) {
	this.accountno = accountno;
}
public String getIfscno() {
	return ifscno;
}
public void setIfscno(String ifscno) {
	this.ifscno = ifscno;
}
public Double getBalance() {
	return balance;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "LinkAccountEnttity [id=" + id + ", accountno=" + accountno + ", ifscno=" + ifscno + ", balance=" + balance
			+ ", mobile=" + mobile + ", name=" + name + "]";
}
public LinkAccountEnttity(int id, int accountno, String ifscno, Double balance, long mobile, String name) {
	super();
	this.id = id;
	this.accountno = accountno;
	this.ifscno = ifscno;
	this.balance = balance;
	this.mobile = mobile;
	this.name = name;
}
public LinkAccountEnttity() {
	super();
	// TODO Auto-generated constructor stub
}




}
