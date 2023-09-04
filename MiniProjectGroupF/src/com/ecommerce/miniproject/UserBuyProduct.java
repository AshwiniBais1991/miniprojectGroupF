package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserBuyProduct extends UserViewProduct {

	private String username;
	private int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}



	public void BuyProduct() throws SQLException {
		
		try {
			System.out.println("log in first");
			UserLogin userLogin = new UserLogin();
			userLogin.gerUserNameAndPasswordForLogin();
			String uname = userLogin.getRegisteredUsername();
			setUsername(uname);
			UserBuyProduct userBuyProduct = new UserBuyProduct();
			LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
			Connection connection =null;
			connection = loadDriverandCreateConnetion.getconnetion();
			PreparedStatement preparedStatement = connection.prepareStatement("select userid from registereduserdetail where username = ?");
			preparedStatement.setString(1, userLogin.getRegisteredUsername());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int userid	= rs.getInt("userid");
				//setUserid(userid);
				getInputFromUser(userid);
			}
			//userBuyProduct.getProductDetails();
//			ScannerInput scannerInput= new ScannerInput();
//			scannerInput.getuserinput();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (java.util.NoSuchElementException e) {
			e.printStackTrace();
		}
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Id to buy product");
		int productId = scanner.nextInt();
		System.out.println("Enter the quantity");
		int quantity = scanner.nextInt();
		getProductDetailFromTable(getUserid(),productId,quantity);*/
		

	}
	public void getInputFromUser(int userid) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Product Id to buy product");
		int productId = scanner.nextInt();
		System.out.println("Enter the quantity");
		int quantity = scanner.nextInt();
		try {
			getProductDetailFromTable(userid,productId,quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getProductDetailFromTable(int userid,int productId, int quantity) throws SQLException{
		
		String productname ;
		float price ;
		String description;
		try {
			UserBuyProduct userBuyProduct = new UserBuyProduct();
			Connection connection = userBuyProduct.getconnetion();
			PreparedStatement preparedStatement = connection.prepareStatement("Select *from productdetail where productid = ?");
			preparedStatement.setInt(1, productId);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				productname = resultset.getString("productname");
				price = resultset.getFloat("price");
				description = resultset.getString(3);
				System.out.println("Product id >> " + resultset.getInt(1));
				System.out.println("Product Name >> "+ resultset.getString(2));
				System.out.println("Product Discription >> "+ resultset.getString(3));
				System.out.println("Available Quantity >> "+ resultset.getInt(4));
				System.out.println("Price >> " + resultset.getFloat(5));
				
				insertValuesInCartTable( userid ,productId ,productname,quantity,price, description );
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	
	
	public void insertValuesInCartTable(int userid,int productId, String productname,int quantity, float price , String description) throws SQLException {
		
		try {
			UserBuyProduct userBuyProduct = new UserBuyProduct();
			Connection connection = userBuyProduct.getconnetion();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into cartdetail( userid,productid ,quantity ,price ,productname,descriptions)values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, userid);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setFloat(4, price);
			preparedStatement.setString(5, productname);
			preparedStatement.setString(6, description);
			preparedStatement.executeUpdate();
			buyAnotherProduct();
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public void buyAnotherProduct() throws ClassNotFoundException, SQLException {
		System.out.println("do you want to buy another product (Yes/No)");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();
		if(ans.equals("Yes")) {
			BuyProduct();	
		}
		if(ans.equals("No")) {
			viewCart();	
			
		}
	}
	public void viewCart() {
		System.out.println("Do you want to view cart (Yes/No)");
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();
		if(ans.equals("Yes")) {
			try {
				UserViewCart userViewCart = new UserViewCart();
				userViewCart.getCartDetail();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
}
	
	