package com.pom.android.EcommercApp.util;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="HomeMenuList")
	public Object[][] homeMenuList(){
		Object[][] data = new Object[1][3];
		data[0][0] = "Home";
		data[0][1] = "Notifications";
		data[0][2] = "Messages";
		
		return data;
	}
	
	@DataProvider(name="HomeMenu_MyEbayList")
	public Object[][] homeMenu_MyEbayList(){
		Object[][] data = new Object[1][3];
		data[0][0] = "Watching";
		data[0][1] = "Purchases";
		data[0][2] = "Bids & Offers";
		data[0][3] = "Watching";
		data[0][4] = "Purchases";
		data[0][5] = "Bids & Offers";
		data[0][6] = "Selling";
		data[0][7] = "Following";
		data[0][8] = "Categories";
		data[0][9] = "Deals";
		data[0][10] = "Settings";
		data[0][11] = "Help & Contact";
		return data;
	}
}
