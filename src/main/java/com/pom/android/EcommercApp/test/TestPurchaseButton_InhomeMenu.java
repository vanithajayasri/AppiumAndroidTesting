package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.PurchasesPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestPurchaseButton_InhomeMenu  extends BaseTest{
	@Test
	public void purchasesButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Purchases");
		test.log(LogStatus.INFO, "clicked on the Messages button in home Navigation menu");
		
		PurchasesPage purchasePage = new PurchasesPage(aDriver,test);
		
		String actualTitle = purchasePage.getTitle();
		String expectedTitle = "Purchases";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Purchases page title");
	}
		
		@AfterMethod
		public void quiting(){
			quitApp();
		}
}
