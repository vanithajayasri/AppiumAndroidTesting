package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HelpAndContactPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestHelpAndContact_InHomeMenu extends BaseTest {
	@Test
	public void helpAndContactButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Help & Contact");
		test.log(LogStatus.INFO, "clicked on the Help & Contact button in home Navigation menu");
		
		HelpAndContactPage hcPage = new HelpAndContactPage(aDriver,test);
		String actualTitle = hcPage.getTitle();
		String expectedTitle = "Help & Contact";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Help & Contact page title");
		
		//verfiy search text box 
		String expectedText ="Enter a keyword or topic";
		String actualText = hcPage.getSearchBox();
		Assert.assertTrue(actualText.equalsIgnoreCase(expectedText), "text in the search box not matches ");
		
		test.log(LogStatus.INFO, "verified Help & Contact page search text box  successfully");	
		
	}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
