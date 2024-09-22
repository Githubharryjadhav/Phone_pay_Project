package com.hefshine.phonepay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Data
public class Phonepayuser {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
String name;
long mobile;
int pin;
int otp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
public int getPin() {
	return pin;
}
public void setPin(int pin) {
	this.pin = pin;
}
public int getOtp() {
	return otp;
}
public void setOtp(int otp) {
	this.otp = otp;
}
@Override
public String toString() {
	return "Phonepayuser [id=" + id + ", name=" + name + ", mobile=" + mobile + ", pin=" + pin + ", otp=" + otp + "]";
}
public Phonepayuser(int id, String name, long mobile, int pin, int otp) {
	super();
	this.id = id;
	this.name = name;
	this.mobile = mobile;
	this.pin = pin;
	this.otp = otp;
}
public Phonepayuser() {
	super();
	// TODO Auto-generated constructor stub
}

	

}
