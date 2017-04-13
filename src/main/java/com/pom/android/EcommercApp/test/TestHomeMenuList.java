package com.pom.android.EcommercApp.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.base.BasePage;
import com.pom.android.EcommercApp.pages.CategoriesPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestHomeMenuList extends BaseTest{

	@Test
	public void homeMenuListTest() throws InterruptedException, ParseException, IOException{
		
		launchApp();
			
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		String [] expectedMenuList = {"Home","Notifications","Messages"};
		String[] menu = homePage.getMenuList(0,3);
		
		for(int i =0 ;i<menu.length ;i++){
			Assert.assertTrue(menu[i].equalsIgnoreCase(expectedMenuList[i]),"Not matches");
		}
		
			
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}
		
}
