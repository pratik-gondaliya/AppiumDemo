package com.volProject.AppiumDemo;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSettings {

	AndroidDriver driver;
	
	@BeforeClass
	public void initOpenSettingclass()
	{
		System.out.println("init open Setting");
		AppiumDriver appiumDriver = new AppiumDriver();
		appiumDriver.setAppPackageName("com.android.settings");
		appiumDriver.setAppLauncherActivity("com.android.settings.Settings");
		driver = (AndroidDriver) appiumDriver.getDriver();
		
	}
	
	@Test
	public void test1()
	{
		WebElement listElement = driver.findElement(By.id("android:id/list"));
		listElement.click();
		System.out.println("Test open setting");
	}
	
	@AfterClass
	public void destoryOpenSettingClass()
	{
		System.out.println("destroy open Setting");
		driver.quit();
	}
}
