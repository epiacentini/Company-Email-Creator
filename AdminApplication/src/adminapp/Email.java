package adminapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private Integer mailCapacity = 500;
	private String altEmail;
	private String email;
	private String companySuffix = "company.com";
	
	//constructor
	public Email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Email created: " + this.firstName + " " + this.lastName);
		
		this.department = setDepartment();
		
		this.password = randPassword(10);
		
		//generate email
		if(department != "")
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		else
			email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
		
	}
	
	//request department
	private String setDepartment() {
		System.out.print("Enter your current department");
		
		Scanner in = new Scanner(System.in);
		String departmentValue = in.nextLine();
		
		departmentValue = departmentValue.toLowerCase();
		
		switch(departmentValue) {
		case "sales":
			return "sales";
		case "accounting":
			return "acc";
		case "development":
			return "dev";
		default:
			return "";
		}
	}
	
	//generate a password for user
	private String randPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// set mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailCapacity = capacity;
	}
	
	//set alternate email
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}
	
	//change user password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	//getter methods
	public int getMailCapacity() {
		return mailCapacity;
	}
	
	public String getAltEmail() {
		return altEmail;
	}
	
	public String getCredentials() {
		return "First Name: " + this.firstName + "\nLast Name: " + this.lastName + "\nEmail: " + email + "\nDepartment: " + department + "\nMailbox Capacity: " + mailCapacity + "mb";
	}
	
}
