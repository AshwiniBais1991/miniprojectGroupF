package com.ecommerce.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriverandCreateConnetion {
	
	public Connection getconnetion() throws ClassNotFoundException {
		Connection connection= null;
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceminiproject1",
										"root", "Ashwini@1991");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		return connection;
		
	}

}
