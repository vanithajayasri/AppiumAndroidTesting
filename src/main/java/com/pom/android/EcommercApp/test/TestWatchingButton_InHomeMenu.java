package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.MessagesPage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestWatchingButton_InHomeMenu extends BaseTest {
	@Test
	public void watchingButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Watching");
		test.log(LogStatus.INFO, "clicked on the Messages button in home Navigation menu");
		
		WatchingPage watchPage = new WatchingPage(aDriver,test);
		String actualTitle = watchPage.getTitle();
		String expectedTitle = "Watching";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the watching page title");
		
		//verfiy tabs
		String[] expectedTabs ={"Active","Ended"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			String actualTab = watchPage.getTabsInWatchingPage(expectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified watching page tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
