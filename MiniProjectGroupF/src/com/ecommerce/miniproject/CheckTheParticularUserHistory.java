package com.ecommerce.miniproject;

import java.sql.Connection;

public class CheckTheParticularUserHistory {
	public void getCheckTheParticularUserHistory() {
		LoadDriverandCreateConnetion loadDriverandCreateConnetion = new LoadDriverandCreateConnetion();
		try {
			Connection connection = loadDriverandCreateConnetion.getconnetion();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
