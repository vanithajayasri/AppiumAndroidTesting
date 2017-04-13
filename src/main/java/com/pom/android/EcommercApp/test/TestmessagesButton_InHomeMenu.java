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
import com.pom.android.EcommercApp.pages.NotificationsPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestmessagesButton_InHomeMenu extends BaseTest{
	@Test
	public void navigationButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Messages");
		test.log(LogStatus.INFO, "clicked on the Messages button in home Navigation menu");
		
		MessagesPage mesPage = new MessagesPage(aDriver,test);
		String actualTitle = mesPage.getTitle();
		String expectedTitle = "Messages";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the messages page title");
		
		//verfiy tabs
		String[] expectedTabs ={"INBOX","SENT","MY FOLDER 1","ARCHIVE"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			String actualTab = mesPage.getTabsInMessagesPage(expectedTabs[i]);
			if(actualTab.equalsIgnoreCase("MY FOLDER 1")){
				mesPage.scrollMessagesMenu();
			}
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified title Messages successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}


}
