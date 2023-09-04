package com.ecommerce.miniproject;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration {
	Scanner scanner = new Scanner(System.in);
	public void getUserRegistrationdetails() throws SQLException {
		
		System.out.println("Enter your First Name");
		String firstName = scanner.next();
		System.out.println("Enter your Last Name ");
		String lastName=scanner.next();
		System.out.println("Enter Username");
		String userName = scanner.next();
		System.out.println("Enter password");
		String userpassword = scanner.next();
		System.out.println("Enter your City");
		String city = scanner.next();
		System.out.println("Enter Your mailId");
		String mailId = scanner.next();
		System.out.println("Enter Your Mobile number");
		String mobileNumber= scanner.next();
		passUserRegistrationInput(firstName, lastName, userName,userpassword,city,mailId,mobileNumber);
		
	}
	public void passUserRegistrationInput(String firstName,String lastName, String userName ,String userpassword,String city,String mailId, String mobileNumber) throws SQLException {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			connection = loadDriverandCreateConnetion.getconnetion();
			prepareStatement  = connection.prepareStatement("insert into registereduserdetail(firstName, lastName, userName,passwords,city,mailId,mobileNumber) values(?,?,?,?,?,?,?)");
			prepareStatement.setString(1,firstName);
			prepareStatement.setString(2,lastName);
			prepareStatement.setString(3,userName);
			prepareStatement.setString(4,userpassword);
			prepareStatement.setString(5,city);
			prepareStatement.setString(6,mailId);
			prepareStatement.setString(7,mobileNumber);
			prepareStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}finally {
			scanner.close();
			connection.close();
			prepareStatement.close();
		}
		
	}

}
