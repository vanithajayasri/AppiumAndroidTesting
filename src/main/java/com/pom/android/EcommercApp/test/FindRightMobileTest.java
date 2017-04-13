package com.pom.android.EcommercApp.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pom.android.EcommercApp.pages.CategoriesPage;
import com.pom.android.EcommercApp.pages.CellPhoneDisplayPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FindRightMobileTest extends BaseTest{


	@Test
	public void findRightMobileTest() throws InterruptedException, ParseException, IOException{
	
		launchApp();
		
		HomePage homePage = new HomePage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
		Object categoriesPage =homePage.selectFromNavigationMenu("Categories"); //|Cell Phones & Accessories|Display Phones
		Assert.assertTrue(categoriesPage != null, "could not load the categories page");
		
		CategoriesPage categoryPage = (CategoriesPage)categoriesPage;
		//Object cellPage = categoryPage.selectCategoriesMenu("Books","Audiobooks") ;
		Object cellPage = categoryPage.selectCategoriesMenu("Cell Phones & Accessories","Display Phones") ;	
		
		CellPhoneDisplayPage  cellDisplayPage = (CellPhoneDisplayPage)cellPage;
		
		test.log(LogStatus.INFO,"test passed");
		
	}
	
	@AfterMethod
	public void quiting(){
		quitApp();
	}

}
