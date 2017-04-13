package com.pom.android.EcommercApp.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DealsPage extends BasePage {
	//constructor
	public DealsPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
//verify title
	public String getTitle(){
		AndroidElement title = aDriver.findElement(By.id("com.ebay.mobile:id/title"));
		return title.getText();
	}
//verfiy tabs in messages page
	public String getTabsInDealsPage(String tabName){
				//verfiy tabs
			AndroidElement tab = aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+tabName +"']"));
			return tab.getText();
		}

	public void scrollDealsMenu(){
		int x = aDriver.findElement(By.xpath("//android.widget.TextView[@text='Home & Garden']")).getLocation().x;
		int y = aDriver.findElement(By.xpath("//android.widget.TextView[@text='Home & Garden']")).getLocation().y;
		aDriver.swipe(x, y, x-500, y, 3000);
		test.log(LogStatus.INFO, "scrolled down the navigation menu");
	}
}
