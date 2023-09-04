package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserViewCart extends LoadDriverandCreateConnetion {
	static int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
public void getCartDetail() throws SQLException {
	

	try {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		UserLogin userLogin = new UserLogin();
		userLogin.gerUserNameAndPasswordForLogin();
		String username = userLogin.getRegisteredUsername();
		Connection connection = loadDriverandCreateConnetion.getconnetion();
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from cartdetail where userid =?");
		preparedStatement.setInt(1, userLogin.getRegisteredUserid());
		ResultSet resultset = preparedStatement.executeQuery();
		System.out.println("Products in cart >>");
		while(resultset.next()){
			userid = resultset.getInt(2);
			System.out.println("userid is >> "+ resultset.getInt(2));
			System.out.println("Product id is >> " + resultset.getInt(3));
			System.out.println("Product name is >>" + resultset.getString(6));
			System.out.println("Product description >> "+ resultset.getString(7));
			System.out.println("quantity is >> " + resultset.getInt(4));
			System.out.println("price is >> " + resultset.getFloat(5));
		
			//getuserid(userid);		
		}
		//return userid;
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
}
    /*public void getuserid(int userid) {
    	CalculateBill calculateBill = new CalculateBill();
    	try {
			calculateBill.totalBillAmount(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}*/
}
