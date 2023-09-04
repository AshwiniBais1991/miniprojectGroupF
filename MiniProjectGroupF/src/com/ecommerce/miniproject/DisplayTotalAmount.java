package com.ecommerce.miniproject;

import java.sql.SQLException;

public class DisplayTotalAmount {
	public void displayTotalAmountToEnduser() {
	CalculateBill calculateBill = new CalculateBill();
	try {
		calculateBill.totalBillAmount();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

}
}