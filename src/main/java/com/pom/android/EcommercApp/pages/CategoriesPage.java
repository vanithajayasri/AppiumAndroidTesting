package com.pom.android.EcommercApp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CategoriesPage extends BasePage{

	//constructor
	public CategoriesPage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
	public boolean findItem(List<AndroidElement> categoriesList,String categoriesItem){
		boolean result = false;
		for(AndroidElement cl:categoriesList ){
			if((cl.getText()).equals(categoriesItem)){
				result= true;
			}
			
		}
		return result;
	}
	
	public String[]  findCategoriesMenu(int size){
		List<AndroidElement>  categoriesList= aDriver.findElements(By.className("android.widget.TextView")); 
		
		int height = aDriver.manage().window().getSize().height;
		int y_max = aDriver.findElement(By.id("com.ebay.mobile:id/title")).getLocation().y;
		int i=0;
		String[] menuItem = new String[size];
		while(i<size){
			System.out.println("-----------------------------");
			for(AndroidElement cl : categoriesList){
				if((cl.getText().equals("Categories"))|| (cl.getText().equals(""))){
					continue;
				}
				menuItem[i++] =cl.getText();
				System.out.println(cl.getText());
				if(cl.getText().equalsIgnoreCase("Everything Else")){
					break;
				}
			}
			aDriver.swipe(500, height-20 ,500, y_max, 6000);
		}
		return menuItem;
	}
	
	public Object selectCategoriesMenu(String categoriesItem,String option) throws InterruptedException{
		test.log(LogStatus.INFO, "selecting the category item");
	
		
		aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+categoriesItem+"']"));
		Thread.sleep(5000);
		//aDriver.findElementByAndroidUIAutomator("UiScrollable(UiSelector().resourceId(\"com.ebay.mobile:id/channel_content\")).scrollIntoView(UiSelector().textContains('"+categoriesItem+"'))").click();
		test.log(LogStatus.INFO, "selected the "+categoriesItem +"category item successfully ");
		
		aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+option+"']")).click();
		test.log(LogStatus.INFO, "selected the "+option +" item successfully");
		Thread.sleep(5000);
		
		CellPhoneDisplayPage cellPage = new CellPhoneDisplayPage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver), cellPage);
		return cellPage;
	}

}
