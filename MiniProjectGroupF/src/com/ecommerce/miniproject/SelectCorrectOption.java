package com.ecommerce.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectCorrectOption {
	public void selectCorrectOption() throws ClassNotFoundException {
		System.out.println("Enter Your choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		try {
		switch(choice) {
		
			case 1 : 
				UserRegistration userRegistration = new UserRegistration();
				userRegistration.getUserRegistrationdetails();
				break;
			
			case 2 :
				UserLogin userLogin = new UserLogin();
				userLogin.gerUserNameAndPasswordForLogin();
				break;
				
			case 3 :
				UserViewProduct userViewProduct = new UserViewProduct();
				userViewProduct.getProductDetails();
				break;
				
			case 4 :
				UserBuyProduct userBuyProduct = new UserBuyProduct();
				userBuyProduct.BuyProduct();
				break;
				
			case 5 :
				UserViewCart userViewCart = new UserViewCart();
				userViewCart.getCartDetail();
				break;
				
			case 6 :
				PurchaseTheItem purchaseTheItem = new PurchaseTheItem();
				purchaseTheItem.purchaseItem();
				break;
				
			case 7 :
				AddProductItem addProductItem = new AddProductItem();
				addProductItem.getAnswerToAddItemInProductDetailTable();
				break;
				
			case 8 :
				CalculateBill calculateBill = new CalculateBill();
				calculateBill.calculate();
				break;
				
			case 9 :
				DisplayTotalAmount displayTotalAmount = new DisplayTotalAmount();
				displayTotalAmount.displayTotalAmountToEnduser();
				break;
				
			case 10 :
				CheckQuantity checkQuantity = new CheckQuantity();
				checkQuantity.getProductQuantity();
				break;
				
			case 11 :
				CheckRegisteredUser checkRegisteredUser = new CheckRegisteredUser();
				checkRegisteredUser.getRegisteredUser();
				break;
				
			case 12 :
				DisplayUserHistory displayUserHistory = new DisplayUserHistory();
				displayUserHistory.getUserHistory();
				break;
				
			case 13 :
				UserViewProduct userViewProduct1 = new UserViewProduct();
				userViewProduct1.getProductDetails();
				break;
				
			case 14 :
				System.out.println("you are not registered user ... Not able to purchase items");
				break;	
				
				
				
		}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


