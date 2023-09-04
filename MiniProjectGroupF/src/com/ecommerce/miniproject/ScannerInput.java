package com.ecommerce.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

public class ScannerInput {
	public void getuserinput() {
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Id to buy product");
		int productId = scanner.nextInt();
		System.out.println("Enter the quantity");
		int quantity = scanner.nextInt();
		
		UserBuyProduct userBuyProduct = new UserBuyProduct();
		userBuyProduct.getProductDetailFromTable(userBuyProduct.getUserid(), productId,quantity);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
