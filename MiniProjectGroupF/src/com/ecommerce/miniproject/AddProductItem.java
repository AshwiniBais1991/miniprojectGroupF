package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProductItem {
	Scanner scanner = new Scanner(System.in);
	public void addProductInProductDetailTable() throws SQLException {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		Scanner scanner = new Scanner(System.in);
		try {
			Connection connection = loadDriverandCreateConnetion.getconnetion();
			PreparedStatement preparedstatement = connection.prepareStatement("insert into productdetail(productname,descriptions,quantity, price)values(?,?,?,?)");
			System.out.println("Enter Product name");
			String productname = scanner.nextLine();
			preparedstatement.setString(1, productname);
			System.out.println("Enter product Description");
			String description = scanner.nextLine();
			preparedstatement.setString(2, description);
			System.out.println("Enter product quantity");
			int quantity = scanner.nextInt();
			preparedstatement.setInt(3, quantity);
			System.out.println("Enter product price");
			Float price = scanner.nextFloat();
			preparedstatement.setFloat(4, price);
			preparedstatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
	}
	public void getAnswerToAddItemInProductDetailTable() {
		System.out.println("Do you want add product (Yes/No)");
		String ans = scanner.next();
		if(ans.contains("Yes")) {
			try {
				addProductInProductDetailTable();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
