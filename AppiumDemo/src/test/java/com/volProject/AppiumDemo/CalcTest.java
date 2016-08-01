package com.volProject.AppiumDemo;



import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcTest{
	AndroidDriver driver;
	@BeforeClass
	public void beforeClassFirstTest()
	{
		AppiumDriver appiumDriver=new AppiumDriver();
		appiumDriver.setAppPackageName("com.wingtech.calc");
		appiumDriver.setAppLauncherActivity("Calculator");
		driver = (AndroidDriver) appiumDriver.getDriver();
		
		System.out.println("Calc Test Initiated");
	}
	@Test
	public void test1(){

		System.out.println("Calc Test 1 Running");
		WebElement four = driver.findElement(By.id("com.wingtech.calc:id/digit4"));
		WebElement plus = driver.findElement(By.id("com.wingtech.calc:id/plus"));
		WebElement equal = driver.findElement(By.id("com.wingtech.calc:id/equal"));
		four.click();
		plus.click();
		four.click();
		equal.click();
		WebElement edit = driver.findElement(By.className("android.widget.EditText"));
		Assert.assertEquals(edit.getText().toString().trim(), "8");
	}
	@Test
	public void test2(){
		
		System.out.println("Calc Test 2 Running");
		WebElement six 		= 	driver.findElement(By.id("com.wingtech.calc:id/digit6"));
		WebElement minus 	= 	driver.findElement(By.id("com.wingtech.calc:id/minus"));
		WebElement two 		= 	driver.findElement(By.id("com.wingtech.calc:id/digit2"));
		WebElement equal 	= 	driver.findElement(By.id("com.wingtech.calc:id/equal"));
		six.click();
		minus.click();
		two.click();
		equal.click();
		WebElement edit = driver.findElement(By.className("android.widget.EditText"));
		Assert.assertEquals(edit.getText().toString().trim(), "4");
	}
	@AfterClass
	public void afterClassFirstTest(){
		
		System.out.println("Calc Test Destroyed");
		driver.quit();
	}
}
