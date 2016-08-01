package com.volProject.AppiumDemo;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendMessage {
	AndroidDriver driver;

	@BeforeClass
	public void initOpenSettingclass()
	{
		System.out.println("init open Setting");
		AppiumDriver appiumDriver = new AppiumDriver();
		appiumDriver.setAppPackageName("com.lenovo.ideafriend");
		appiumDriver.setAppLauncherActivity("com.lenovo.ideafriend.alias.MmsActivity");
		driver = (AndroidDriver) appiumDriver.getDriver();

	}

	@Test
	public void test1() throws NoSuchElementException
	{	
		WebElement listItem = driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]"));
		listItem.click();
		WebElement text = driver.findElement(By.id("com.lenovo.ideafriend:id/embedded_text_editor"));
		text.sendKeys("got it ?");
		WebElement sendButton = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.lenovo.ideafriend:id/send_button_sim2']/android.widget.ImageView"));
		sendButton.click();
		System.out.println("Test open setting");
		

	}

	@AfterClass
	public void destoryOpenSettingClass()
	{
		System.out.println("destroy open Setting");
		driver.quit();
	}
}
