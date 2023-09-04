package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckRegisteredUser {
	public void getRegisteredUser() throws SQLException {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		
			Connection connection = null;
			try {
				connection = loadDriverandCreateConnetion.getconnetion();
			
				System.out.println("Enter user id >> ");
				Scanner scanner = new Scanner(System.in);
				int id= scanner.nextInt();
				PreparedStatement ps = connection.prepareStatement("Select * from registereduserdetail where userid = ?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println("user firstname >> " +rs.getString(1));
					System.out.println("user lastname >> "+ rs.getString(2));
					System.out.println("user city >> " +rs.getString(5));
					System.out.println("user mailId >> "+ rs.getString(6));
					System.out.println("User mobile number >> "+rs.getString(7));
				
			}
			scanner.close();
	
		} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
}
}
