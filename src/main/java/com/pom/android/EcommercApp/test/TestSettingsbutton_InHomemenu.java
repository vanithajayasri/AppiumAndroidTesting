package com.pom.android.EcommercApp.test;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.pages.SettingsPage;
import com.pom.android.EcommercApp.pages.WatchingPage;
import com.relevantcodes.extentreports.LogStatus;

public class TestSettingsbutton_InHomemenu extends BaseTest {
	@Test
	public void settingsButtonTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		
		homePage.selectButton_FromNavigationMenu("Settings");
		test.log(LogStatus.INFO, "clicked on the Settings button in home Navigation menu");
		
		SettingsPage settingsPage = new SettingsPage(aDriver,test);
		String actualTitle = settingsPage.getTitle();
		String expectedTitle = "Settings";
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle), "Title not matches");
		test.log(LogStatus.INFO, "verifired the Settings page title");
		
		//verfiy tabs
		String[] expectedTabs ={"Account information","About"};
		
		for(int i=0;i<expectedTabs.length ;i++ ){
			String actualTab = settingsPage.getTabsInSettingsPage(expectedTabs[i]);
			Assert.assertTrue(actualTab.equalsIgnoreCase(expectedTabs[i])," not matches ");
			
		}
		
		
		test.log(LogStatus.INFO, "verified Settings page tabs successfully");	
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}

}
