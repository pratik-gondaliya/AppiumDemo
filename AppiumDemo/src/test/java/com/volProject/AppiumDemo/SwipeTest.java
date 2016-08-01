package com.volProject.AppiumDemo;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwipeTest{
	AndroidDriver driver;

	@BeforeClass
	public void beforeClassSwipeTest()
	{
		AppiumDriver appiumDriver=new AppiumDriver();
		driver = (AndroidDriver) appiumDriver.getDriver();
		System.out.println("\nSwipe Test Initiated");
	}
	@Test
	public void test1(){

		System.out.println("Swipe Test Running");

		driver.findElement(By.id("com.baoyz.swipemenulistview.demo:id/button1")).click();

		WebElement listItem = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='com.baoyz.swipemenulistview.demo:id/listView']/android.widget.FrameLayout[2]"));

		MobileElement listItemM = (MobileElement)listItem;
		Point listItemCenter = listItemM.getCenter();
		Point listItemLocation = listItemM.getLocation();

		driver.swipe(listItemCenter.getX(), listItemLocation.getY(), listItemCenter.getX()-200,listItemLocation.getY(),100);
		WebElement deleteImageButton =listItemM.findElement(By.className("android.widget.ImageView"));
		deleteImageButton.click();

	}
	@AfterClass
	public void afterClassSwipeTest(){
		System.out.println("Swipe Test destroyed\n");
		driver.quit();
	}
}
