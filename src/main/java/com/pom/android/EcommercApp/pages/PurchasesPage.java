package com.pom.android.EcommercApp.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class PurchasesPage extends BasePage {
	//constructor
	public PurchasesPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
//verify title
	public String getTitle(){
		AndroidElement title = aDriver.findElement(By.id("com.ebay.mobile:id/title"));
		return title.getText();
	}
}
