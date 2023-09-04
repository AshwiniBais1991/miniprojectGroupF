package com.ecommerce.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

public class PurchaseTheItem extends UserViewCart {
	
	public void purchaseItem() {
		try {
		
		//UserViewCart userViewCart = new UserViewCart();
		//userViewCart.getCartDetail();
		
		System.out.println("Do you want to purchase items (Yes/No)");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();
		if(ans.equals("Yes")) {
			UserViewCart userViewCart = new UserViewCart();
			userViewCart.getCartDetail();
		CalculateBill calculateBill = new CalculateBill();
		calculateBill.totalBillAmount();
		}
		else{System.out.println("You have selected No");}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
