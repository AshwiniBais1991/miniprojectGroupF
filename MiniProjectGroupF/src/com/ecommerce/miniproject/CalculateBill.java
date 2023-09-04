package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateBill  {
	LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultset = null;
	
	public void calculate() throws SQLException {
		try {
			connection = loadDriverandCreateConnetion.getconnetion();
			
			preparedStatement = connection.prepareStatement("select userid ,productid,productname,quantity, price from cartdetail where userid = ?");
			UserBuyProduct userBuyProduct = new UserBuyProduct();
			preparedStatement.setInt(1, userBuyProduct.getUserid());
			ResultSet resultset = preparedStatement.executeQuery();
		
			while(resultset.next()) {
				int productid = resultset.getInt("productid");
				int quantity = resultset.getInt("quantity");
				System.out.println(resultset.getInt("productid") + "  "+resultset.getString("productname")+"  "+ resultset.getInt("quantity")+ "  " + resultset.getFloat("Price"));
				reduceQantityOfProduct(productid,quantity);
				
			}
			totalBillAmount();
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
	}
	
	
	public void totalBillAmount() throws SQLException {
		float sum = 0;
		try {
			connection = loadDriverandCreateConnetion.getconnetion();
			preparedStatement = connection.prepareStatement("select sum(price) from cartdetail where userid = ?");
			//UserLogin userLogin = new UserLogin();
			//UserViewCart userViewCart = new UserViewCart();
			preparedStatement.setInt(1, UserViewCart.userid);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				System.out.println("Total Price is >>");
				float val = resultset.getFloat("sum(price)");
				sum= sum +val;
				
			}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		System.out.println(sum);
		
	}
	public void reduceQantityOfProduct(int productid,int quantity) throws SQLException {
		try {
			connection = loadDriverandCreateConnetion.getconnetion();
			preparedStatement = connection.prepareStatement("update productdetail set quantity - ? where productid=?"); 
			preparedStatement.setInt(1,quantity);
			preparedStatement.setInt(2, productid);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
}

