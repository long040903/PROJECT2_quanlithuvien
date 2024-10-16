package data;

import java.sql.Date;
import java.sql.Time;

public class CustomerData {
	private int customerID;
	private String fullName;
	private String email;
	private String gender;
	private String phoneNumber;
	private Date arriveDate;
	private String status;
	
	public CustomerData() {
		
	}

	public CustomerData(int customerID, String fullName, String email, String gender, String phoneNumber, Date arriveDate, String status) {		
		this.customerID = customerID;
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.arriveDate = arriveDate;
		this.status = status;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
