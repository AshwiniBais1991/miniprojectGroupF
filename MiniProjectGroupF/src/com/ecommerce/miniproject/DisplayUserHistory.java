package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayUserHistory {
	public void getUserHistory() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user id");
		int userid = scanner.nextInt();
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		try {
			Connection connection = loadDriverandCreateConnetion.getconnetion();
			PreparedStatement ps = connection.prepareStatement("select * form cartdetail where userid = ? ");
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("product id is >>  " +rs.getInt(3));
				System.out.println("product description >>  " +rs.getString(7));
				System.out.println("product quantity >>  "+ rs.getInt(4));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
