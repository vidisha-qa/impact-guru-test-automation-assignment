package com.uiAutomation.impactGuru.webPortal.TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.uiAutomation.impactGuru.webPortal.pages.LoginPage;
import com.uiAutomation.impactGuru.webPortal.utilities.BrowserFactory;

public class LoginTestcases {
	
	WebDriver driver;
	
	@Test (priority = 1)
	public void loginApp() throws InterruptedException {
		driver = BrowserFactory.startApplication(driver, "Chrome", "https://staging.igstg.com/fundraiser/help-testdocumentchecklist");
		System.out.println(driver.getTitle());
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login_WebAPP("candidate","igcandidate");
		loginPage.stageAuthentication("impactguru","8nvbil51pp");

	}
	
	@Test (priority = 2)
	public void donate() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.click_Donate();
		loginPage.cardPageField();
		
	}
}
