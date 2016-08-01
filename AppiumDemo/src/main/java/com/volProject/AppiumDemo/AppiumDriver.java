package com.volProject.AppiumDemo;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Volansys
 *
 *	This file contains the Appium Driver 
 *	This will contains total configuration which is require for the Driver
 */
public class AppiumDriver {

	private String browserName;  // Default is Android
	private String version;		// This will be the version of Andoird eg. 4.4.2
	private String deviceName;	// This will be the device name which is get from commmand 'adb devices'
	private String platformName; // This is by default Android 
	private String appPackageName; // fully qualified application Name eg. com.android.abcd
	private String appLauncherActivity; // fully qualified path of Launcher activity eg. com.android.abcd.MainActivity
	private String appiumIpAddress; // This will be IP address of appium server default : 0.0.0.0
	private String appiumPort;      // This will be the port of appium server default : 4723
	public AndroidDriver driver; 		// This will be final output object which is the complete configure driver od appium server
	
	
	
	private void initDriver(){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME",browserName);
		capabilities.setCapability("VERSION",version);
		capabilities.setCapability("deviceName",deviceName); 
		capabilities.setCapability("platformName",platformName);
		capabilities.setCapability("appPackage",appPackageName);
		capabilities.setCapability("appActivity",appLauncherActivity);
		try{
			driver = new AndroidDriver(new URL("http://"+appiumIpAddress+":"+appiumPort+"/wd/hub"),capabilities);
		}
		catch(Exception e){
			
		}
		
	}

	public AppiumDriver() {
		
		appiumIpAddress = "0.0.0.0";
		appiumPort = "4723";
		setDefaultValue();
	}

	public AppiumDriver(String appiumIpAddress, String appiumPort) {
		
		this.appiumIpAddress = appiumIpAddress;
		this.appiumPort = appiumPort;
		setDefaultValue();
	}
	
	public AppiumDriver(String browserName, String version, String deviceName,
			String platformName, String appPackageName,
			String appLauncherActivity, String appiumIpAddress,
			String appiumPort) {
		this.browserName = browserName;
		this.version = version;
		this.deviceName = deviceName;
		this.platformName = platformName;
		this.appPackageName = appPackageName;
		this.appLauncherActivity = appLauncherActivity;
		this.appiumIpAddress = appiumIpAddress;
		this.appiumPort = appiumPort;
	}
	
	

	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
		
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getAppPackageName() {
		return appPackageName;
	}
	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}
	public String getAppLauncherActivity() {
		return appLauncherActivity;
	}
	public void setAppLauncherActivity(String appLauncherActivity) {
		this.appLauncherActivity = appLauncherActivity;
	}
	public String getAppiumIpAddress() {
		return appiumIpAddress;
	}
	public void setAppiumIpAddress(String appiumIpAddress) {
		this.appiumIpAddress = appiumIpAddress;
	}
	public String getAppiumPort() {
		return appiumPort;
	}
	public void setAppiumPort(String appiumPort) {
		this.appiumPort = appiumPort;
	}
	
	
	
	public WebDriver getDriver() {
		initDriver();
		return driver;
	}
	
	private void setDefaultValue()
	{
		browserName = "Android";
		version = "4.4.2";
		deviceName = "Emulator";
		platformName = "Android";
		appPackageName = "com.baoyz.swipemenulistview.demo";
		appLauncherActivity = "MainActivity";
		/*appPackageName = "com.example.pratik.myapplication";
		appLauncherActivity = "com.example.pratik.myapplication.MainActivity";*/
		//initDriver();
	}

	@Override
	public String toString() {
		return "AppiumDriver [browserName=" + browserName + ", version="
				+ version + ", deviceName=" + deviceName + ", platformName="
				+ platformName + ", appPackageName=" + appPackageName
				+ ", appLauncherActivity=" + appLauncherActivity
				+ ", appiumIpAddress=" + appiumIpAddress + ", appiumPort="
				+ appiumPort + "]";
	}
}
