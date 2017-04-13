package com.pom.android.EcommercApp.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pom.android.EcommercApp.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver driver;
	AndroidDriver<AndroidElement> aDriver;
	
	public void launchApp() throws MalformedURLException{
		test = rep.startTest("finRightMobileTest Starts", "Started the test");
		
		File app = new File(System.getProperty("user.dir")+"\\apk\\eBay_5.7.0.10.apk");
		test.log(LogStatus.INFO, "Starting the app");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","SAMSUNG-SM-J20A");
	    capabilities.setCapability("platformVersion", "6.0.1");
	    capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		
		test.log(LogStatus.INFO, "luanching the app");
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		//casting the driver
		aDriver = (AndroidDriver<AndroidElement>) driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO,"luanched app successfully");
	}
	
	public void quitApp(){
		if(rep!=null){
			test.log(LogStatus.INFO,"quit the app successfully");
			
			rep.endTest(test);
			rep.flush();
		}
		if(driver!=null){
			driver.quit();
		}
	}
}
