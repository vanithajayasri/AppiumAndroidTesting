package com.pom.android.EcommercApp.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;

public class SellingPage extends BasePage {
	//constructor
	public SellingPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
//verify title
	public String getTitle(){
		AndroidElement title = aDriver.findElement(By.id("com.ebay.mobile:id/title"));
		return title.getText();
	}
//verfiy tabs in messages page
	public String getTabsInSellingPage(String tabName){
				//verfiy tabs
			AndroidElement tab = aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+tabName +"']"));
			return tab.getText();
		}
		}
