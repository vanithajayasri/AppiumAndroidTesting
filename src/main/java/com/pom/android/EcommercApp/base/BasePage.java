package com.pom.android.EcommercApp.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pom.android.EcommercApp.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public AndroidDriver<AndroidElement> aDriver;
	public ExtentTest test;
	


	public BasePage(AndroidDriver<AndroidElement> aDriver,ExtentTest test) {
		//menu = new TopMenu(aDriver,test);
		//PageFactory.initElements(new AppiumFieldDecorator(aDriver), menu);
		this.aDriver = aDriver;
		this.test=test;
	}
}
