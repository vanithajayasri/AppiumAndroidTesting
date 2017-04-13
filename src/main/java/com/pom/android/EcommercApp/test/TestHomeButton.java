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
import com.relevantcodes.extentreports.LogStatus;

public class TestHomeButton extends BaseTest {
	@Test
	public void homeButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Home");
		homePage.verfiyHomeLogo();
		String[] ExpectedTabs ={"Selling","Deals","Categories","Following"};
		
		for(int i =0 ;i< ExpectedTabs.length ;i++){
			String actualTab = homePage.verfiyTabsInHomePage(ExpectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(ExpectedTabs[i]), "Not matches");
			System.out.println(actualTab);
		}
		
		test.log(LogStatus.INFO, "verified tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
