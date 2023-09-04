package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin {
	
	Scanner scanner = new Scanner(System.in);
	Connection connection = null;
	PreparedStatement preparedStatement=null;
	private String username;
	private String password;
	String registeredUsername;
	int registeredUserid;
	public int getRegisteredUserid() {
		return registeredUserid;
	}
	public void setRegisteredUserid(int registeredUserid) {
		this.registeredUserid = registeredUserid;
	}

	String registeredPassword;

	
	public String getRegisteredPassword() {
		return registeredPassword;
	}
	public void setRegisteredPassword(String registeredPassword) {
		this.registeredPassword = registeredPassword;
	}
	public String getRegisteredUsername() {
		return registeredUsername;
	}
	public void setRegisteredUsername(String registeredUsername) {
		this.registeredUsername = registeredUsername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public void getUsernameAndPasswordFromTable() throws SQLException{
		
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		try {
			connection = loadDriverandCreateConnetion.getconnetion();
			preparedStatement = connection.prepareStatement("Select userid,username,passwords from registereduserdetail");
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				registeredUserid = resultset.getInt("userid");
				registeredUsername = resultset.getString("username");
				registeredPassword = resultset.getString("passwords");
				loginToApplication(registeredUsername , registeredPassword, registeredUserid);	
			}
				
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}
	public void gerUserNameAndPasswordForLogin() {
		System.out.println("Enter username");
		String username = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();
		setUsername(username);
		setPassword(password);
		try {
			getUsernameAndPasswordFromTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loginToApplication(String registeredUsername , String registeredPassword, int registeredUserid) {
		
		if((registeredUsername.equals(getUsername()))&& registeredPassword.equals(getPassword())) {
			setRegisteredUsername(registeredUsername);
			setRegisteredPassword(registeredPassword);
			setRegisteredUserid(registeredUserid);
			System.out.println("Login sucessfull...."  + "   hi  "+registeredUsername);
			
		}
		
		
	}
	

}
