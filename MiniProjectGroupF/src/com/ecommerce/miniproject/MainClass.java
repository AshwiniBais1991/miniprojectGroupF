package com.ecommerce.miniproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MainClass {
	public static void main(String[] args)throws ClassNotFoundException {
		ArrayList<String> user = new ArrayList<String>();
		user.add("1. User Registration");
		user.add("2. User Login");
		user.add("3. User view Product item");
		user.add("4. Buy Product");
		user.add("5. View Cart");
		user.add("6. Purchase the item");
		ArrayList<String> admin = new ArrayList<String>();
		admin.add("7. Add product item");
		admin.add("8. Calculate Bill");
		admin.add("9. Display amount to End User");
		admin.add("10.Check Quantity");
		admin.add("11. Check registered user");
		admin.add("12. Check the particular user history");
		ArrayList<String> guest = new ArrayList<String>();
		guest.add("13. View product item");
		guest.add("14. Not purchase item");
		HashMap<String, ArrayList<String>> sections = new HashMap<String, ArrayList<String>>();
		sections.put("User", user);
		sections.put("Admin", admin);
		sections.put("Guest", guest);
		HashMap<String ,HashMap<String, ArrayList<String>>> ecommerse = new HashMap<String ,HashMap<String, ArrayList<String>>>();
		ecommerse.put("Welcome to E-Commerce based application" , sections);
		System.out.println("Welcome to E-Commerce based application");
		Set<String> s = sections.keySet();
		for(String str : s) {
			System.out.println(str);
			System.out.println(sections.get(str));
			System.out.println();
		}
		
		SelectCorrectOption selectCorrectOption = new SelectCorrectOption();
		selectCorrectOption.selectCorrectOption();
	}
}
