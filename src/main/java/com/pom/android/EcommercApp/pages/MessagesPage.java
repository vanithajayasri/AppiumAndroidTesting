package com.pom.android.EcommercApp.pages;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MessagesPage extends BasePage {
	//constructor
	public MessagesPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
//verify title
	public String getTitle(){
		AndroidElement title = aDriver.findElement(By.id("com.ebay.mobile:id/title"));
		return title.getText();
	}
//verfiy tabs in messages page
	public String getTabsInMessagesPage(String tabName){
				//verfiy tabs
			AndroidElement tab = aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+tabName +"']"));
			return tab.getText();
		}
		
		
	
	public void scrollMessagesMenu(){
		int x = aDriver.findElement(By.xpath("//android.widget.TextView[@text='MY FOLDER 1']")).getLocation().x;
		int y = aDriver.findElement(By.xpath("//android.widget.TextView[@text='MY FOLDER 1']")).getLocation().y;
		aDriver.swipe(x, y, x-300, y, 3000);
		test.log(LogStatus.INFO, "scrolled down the navigation menu");
	}
}
