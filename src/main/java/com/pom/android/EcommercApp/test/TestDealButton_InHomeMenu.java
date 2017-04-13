package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.DealsPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestDealButton_InHomeMenu extends BaseTest {
	@Test
	public void dealsButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Deals");
		test.log(LogStatus.INFO, "clicked on the Deals button in home Navigation menu");
		
		DealsPage dealPage = new DealsPage(aDriver,test);
		String actualTitle = dealPage.getTitle();
		String expectedTitle = "Deals";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Deals page title");
		
		//verfiy tabs
		String[] expectedTabs ={"Featured","Tech","Fashion","Home & Garden","Automotive","Other Deals"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			
			String actualTab = dealPage.getTabsInDealsPage(expectedTabs[i]);
			if(actualTab.equalsIgnoreCase("Home & Garden")){
				dealPage.scrollDealsMenu();
			}
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified Deals page tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}
}
