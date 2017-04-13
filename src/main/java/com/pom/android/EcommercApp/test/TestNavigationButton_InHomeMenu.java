package com.pom.android.EcommercApp.test;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.NotificationsPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestNavigationButton_InHomeMenu extends BaseTest{

	@Test
	public void navigationButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Notifications");
		test.log(LogStatus.INFO, "clicked on the Notifications button in home Navigation menu");
		
		NotificationsPage npage = new NotificationsPage(aDriver,test);
		String actualTitle = npage.getTitle();
		String expectedTitle ="Notifications";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verified title Notifications successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
