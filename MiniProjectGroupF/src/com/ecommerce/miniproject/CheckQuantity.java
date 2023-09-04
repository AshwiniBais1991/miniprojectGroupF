package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantity {
	public void getProductQuantity() throws SQLException {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		try {
			Connection connection = loadDriverandCreateConnetion.getconnetion();
			System.out.println("Enter product id >> ");
			Scanner scanner = new Scanner(System.in);
			int id= scanner.nextInt();
			PreparedStatement ps = connection.prepareStatement("Select quantity from productdetail where productid = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("Product quantity is >> " + rs.getInt("quantity"));
			}
			scanner.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
