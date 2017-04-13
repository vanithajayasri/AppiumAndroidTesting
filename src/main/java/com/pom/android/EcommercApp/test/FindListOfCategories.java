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

import com.pom.android.EcommercApp.pages.CategoriesPage;
import com.pom.android.EcommercApp.pages.HomePage;
import com.pom.android.EcommercApp.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FindListOfCategories extends BaseTest {

	
	@Test
	public void findCategoriesList() throws InterruptedException, ParseException, IOException{
			launchApp();
			
			HomePage homePage = new HomePage(aDriver,test);
			PageFactory.initElements(new AppiumFieldDecorator(aDriver), homePage);
			
			Object categoriesPage =homePage.selectFromNavigationMenu("Categories"); 
			Assert.assertTrue(categoriesPage != null, "could not load the categories page");
			
			CategoriesPage categoryPage = (CategoriesPage)categoriesPage;
			String[] expectedResult ={"Antiques","Art","Baby","Books","Business & Industrial","Cameras & Photo",
					"Cell Phones & Accessories","Clothing, Shoes & Accessories","Coins & Paper Money","Collectibles",
					"Computers/Tablets & Networking","Consumer Electronics","Crafts","Dolls & Bears","DVDs & Movies","eBay Motors",
					"Entertainment Memorabilia","Gift Cards & Coupons","Health & Beauty","Home & Garden","Jewelry & Watches","Music",
					"Musical Instruments & Gear","Pet Supplies","Pottery & Glass","Real Estate","Specialty Services","Sporting Goods",
					"Sports Mem, Cards & Fan Shop","Stamps","Tickets & Experiences","Toys & Hobbies","Travel",
					"Video Games & Consoles","Everything Else" };
			String[] actualResult = categoryPage.findCategoriesMenu(expectedResult.length);
			
			for(int i=0;i<expectedResult.length ;i++){
				Assert.assertTrue(actualResult[i].equals(expectedResult[i]), expectedResult[i] +"not matches " +actualResult[i]);
			}
			test.log(LogStatus.INFO,"displayed categories menu  successfully");
			
		}	
		@AfterMethod
		public void quiting(){
			quitApp();
		}
}
