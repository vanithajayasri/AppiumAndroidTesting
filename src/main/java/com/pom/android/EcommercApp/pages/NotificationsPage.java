package com.pom.android.EcommercApp.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class NotificationsPage extends BasePage {
	//constructor
		public NotificationsPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
			 super(aDriver,test);
			}
		
	//verify title
		public String getTitle(){
			AndroidElement title = aDriver.findElement(By.id("com.ebay.mobile:id/title"));
			return title.getText();
		}
}
