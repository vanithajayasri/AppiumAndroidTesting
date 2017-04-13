package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.BidsAndOffersPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestBidsAndOffers_InHomeMenu extends BaseTest {
	@Test
	public void bidsAndOffersButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Bids & Offers");
		test.log(LogStatus.INFO, "clicked on the Bids & Offers button in home Navigation menu");
		
		BidsAndOffersPage boPage = new BidsAndOffersPage(aDriver,test);
		String actualTitle = boPage.getTitle();
		String expectedTitle = "Bids & Offers";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the watching page title");
		
		//verfiy tabs
		String[] expectedTabs ={"Bids","Offers"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			if(expectedTabs[i].equalsIgnoreCase("Didn't win")){
				continue;
			}
			String actualTab = boPage.getTabsInBDPage(expectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		test.log(LogStatus.INFO, "verified Bids & Offers page tabs successfully");	
	}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}
}
