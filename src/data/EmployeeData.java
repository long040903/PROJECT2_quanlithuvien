package data;

import java.sql.Date;

public class EmployeeData {
	private int employeeID;
	private String fullName;
	private String userName;
	private String email;
	private String phoneNumber;
	private String password;
	private String gender;
	private String employeeImage;
	private String address;
	private Date arriveDate;
	private int roleID;
	
	public EmployeeData() {
		
	}

	public EmployeeData(int employeeID, String fullName, String userName, String email, String phoneNumber, String password, String gender, String employeeImage, String address, Date arriveDate, int roleID) {
		super();
		this.employeeID = employeeID;
		this.fullName = fullName;
		this.userName = userName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.gender = gender;
		this.employeeImage = employeeImage;
		this.address = address;
		this.arriveDate = arriveDate;
		this.roleID = roleID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeImage() {
		return employeeImage;
	}

	public void setEmployeeImage(String employeeImage) {
		this.employeeImage = employeeImage;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	@Override
	public String toString() {
	    return "EmployeeData{" +
	           "id=" + employeeID +
	           ", fullname='" + fullName + '\'' +
	           ", username='" + userName + '\'' +
	           ", email='" + email + '\'' +
	           ", phone_number='" + phoneNumber + '\'' +
	           ", password_hash='" + password + '\'' +
	           ", gender='" + gender + '\'' +
	           ", user_image='" + employeeImage + '\'' +
	           ", address='" + address + '\'' +
	           ", arrive_date=" + arriveDate +
	           '}';
	}
	
	
	
}
