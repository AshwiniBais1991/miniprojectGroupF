package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserViewProduct extends LoadDriverandCreateConnetion {

	public void getProductDetails() throws SQLException {
		UserViewProduct userViewProduct = new UserViewProduct();
		Connection connection = null;
		PreparedStatement preparedStatment= null;
		ResultSet resultset= null;
		try {
			
			connection = userViewProduct.getconnetion();
			preparedStatment = connection.prepareStatement("select*from productdetail order by productid");
			resultset = preparedStatment.executeQuery();
			while(resultset.next()){
				System.out.println("Product id >> " + resultset.getInt(1));
				System.out.println("Product Name >> "+ resultset.getString(2));
				System.out.println("Product Discription >> "+ resultset.getString(3));
				System.out.println("Available Quantity >> "+ resultset.getInt(4));
				System.out.println("Price >> " + resultset.getFloat(5));
			}
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatment.close();

		}
	}
}
