package com.pom.android.EcommercApp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.android.EcommercApp.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage{
	
	//constructor
	public HomePage(AndroidDriver<AndroidElement> aDriver, ExtentTest test){
		 super(aDriver,test);
		}
	
	
	@FindBy(id="com.ebay.mobile:id/home")
	public AndroidElement navigationMenuImage;
	
	@FindBy(id="com.ebay.mobile:id/menuitem_myebay_header")
	public AndroidElement My_ebayHeading;
	
		
	public void selectMenuImage(){
		test.log(LogStatus.INFO, "selecting the navigation menu");
		navigationMenuImage.click();
	}
	
	public void scrollDownMenu(){
		int y = My_ebayHeading.getLocation().y;
		int x = My_ebayHeading.getLocation().x;
		aDriver.swipe(x, y, x, y-500, 3000);
		test.log(LogStatus.INFO, "scrolled down the navigation menu");
	}
	
	public String[] getMenuList(int startIndex,int endIndex){
		selectMenuImage();
		test.log(LogStatus.INFO, "displaying navigation menu");
		scrollDownMenu();
		int size = 0 , k=0;
		List<AndroidElement>menuList = aDriver.findElementsByAndroidUIAutomator("UiSelector().resourceId(\"com.ebay.mobile:id/design_menu_item_text\")");
		String[] menu = new String[endIndex];	
		if(endIndex == 9){
			size = menuList.size();
		
		}
		else{
			size = endIndex;
		}
			for(int i=startIndex;i<size ;i++){
				menu[k] =menuList.get(i).getText();
				System.out.println(menu[k]);
				k++;
			}

		return menu;
	}
	
	public Object selectFromNavigationMenu(String navigationItem) throws InterruptedException{
				
		selectMenuImage();
		scrollDownMenu();
		aDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+navigationItem+"']")).click();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "selected "+ navigationItem +" successfully ");
		
		CategoriesPage categoryPage = new CategoriesPage(aDriver,test);
		PageFactory.initElements(aDriver, categoryPage);
		return  categoryPage;
	}
	
	public void selectButton_FromNavigationMenu(String navigationItem) throws InterruptedException{
		
		selectMenuImage();
		scrollDownMenu();
		aDriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+navigationItem+"']")).click();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "selected "+ navigationItem +" successfully ");
		
	}
	
	public void verfiyHomeLogo(){
		//verfiy logo
		AndroidElement logo =aDriver.findElement(By.id("com.ebay.mobile:id/logo"));
		System.out.println(logo.getText());
	}
	
	public String verfiyTabsInHomePage(String tabName){
		
		//verfiy tabs
		AndroidElement tab = aDriver.findElement(By.xpath("//android.widget.TextView[@text='"+tabName +"']"));
		return tab.getText();
	}
}
