package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.SellingPage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestSellingButon_InHomeMenu extends BaseTest {
	@Test
	public void sellingButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Selling");
		test.log(LogStatus.INFO, "clicked on the Selling button in home Navigation menu");
		
		SellingPage sellingPage = new SellingPage(aDriver,test);
		String actualTitle = sellingPage.getTitle();
		String expectedTitle = "Selling";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Selling page title");
		
		//verfiy tabs
		String[] expectedTabs ={"CASH IT IN","How it works"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			String actualTab = sellingPage.getTabsInSellingPage(expectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified Selling page tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
