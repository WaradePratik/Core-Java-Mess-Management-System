package com.mess;

import java.io.Serializable;
import java.time.LocalDate;

public class Mess implements Serializable {
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String passsword;
	private String address;
	private LocalDate registerDate;
	private LocalDate lastDate;
	private String phoeNo;
	private Plan plan;
	private double fees;
	public Mess(int customerId, String firstName, String lastName, String email, String passsword, String address,
			LocalDate registerDate,LocalDate lastDate, String phoeNo, Plan plan,double fees) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passsword = passsword;
		this.address = address;
		this.registerDate = registerDate;
		this.lastDate=lastDate;
		this.phoeNo = phoeNo;
		this.plan = plan;
		this.fees=fees;
	}
	@Override
	public String toString() {
		return "customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", passsword=" + passsword + ", address=" + address + ", registerDate=" + registerDate
				+ ", lastDate= "+ lastDate +", phoeNo=" + phoeNo + ", plan=" + plan + ", Charges= " +fees;
	}
	public LocalDate getLastDate() {
		return lastDate;
	}
	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public String getPhoeNo() {
		return phoeNo;
	}
	public void setPhoeNo(String phoeNo) {
		this.phoeNo = phoeNo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	
}
