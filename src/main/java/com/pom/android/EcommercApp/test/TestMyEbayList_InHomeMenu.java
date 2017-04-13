package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;

public class TestMyEbayList_InHomeMenu extends BaseTest{
	@Test
	public void myebayListTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		String [] expectedMenuList = {"Watching","Purchases","Bids & Offers","Selling",
				"Following","Categories","Deals","Settings","Help & Contact"};
		String[] menu = homePage.getMenuList(3, 9);
		
		for(int i =0 ;i<menu.length ;i++){
			Assert.assertTrue(menu[i].equalsIgnoreCase(expectedMenuList[i]),"Not matches");
		}
		
			
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}
		

}
