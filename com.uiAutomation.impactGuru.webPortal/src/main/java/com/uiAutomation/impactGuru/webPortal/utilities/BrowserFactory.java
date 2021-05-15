package com.uiAutomation.impactGuru.webPortal.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
		
		if(browserName.equals("Chrome"))
		{	
			System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			
		}
		else	
		{
			System.out.println("We do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}