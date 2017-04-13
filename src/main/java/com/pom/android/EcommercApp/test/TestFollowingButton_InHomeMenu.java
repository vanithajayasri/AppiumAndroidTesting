package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.FollowingPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestFollowingButton_InHomeMenu extends BaseTest {
	@Test
	public void followingButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Following");
		test.log(LogStatus.INFO, "clicked on the Following button in home Navigation menu");
		
		FollowingPage followPage = new FollowingPage(aDriver,test);
		String actualTitle = followPage.getTitle();
		String expectedTitle = "Following";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Following page title");
		
		//verfiy tabs
		String[] expectedTabs ={"Searches","Members","Collections"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			String actualTab = followPage.getTabsInFollowingPage(expectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified watching page tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}}
