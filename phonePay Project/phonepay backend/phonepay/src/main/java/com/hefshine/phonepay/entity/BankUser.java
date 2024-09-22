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

@Entity@Data
public class BankUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankUser(int id, String name, int accountNumber, String iFSCcode, Double balance, long mobile, int pin) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		IFSCcode = iFSCcode;
		this.balance = balance;
		this.mobile = mobile;
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "BankUser [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", IFSCcode=" + IFSCcode
				+ ", balance=" + balance + ", mobile=" + mobile + ", pin=" + pin + "]";
	}
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
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
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
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	String name;
	int accountNumber;
	String IFSCcode;
	Double balance;
	long mobile;
	int pin;
	
	
}
