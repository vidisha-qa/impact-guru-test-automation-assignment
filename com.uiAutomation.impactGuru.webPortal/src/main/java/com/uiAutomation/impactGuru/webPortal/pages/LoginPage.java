package com.uiAutomation.impactGuru.webPortal.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	static WebDriverWait wait;
	Robot rb;

	public LoginPage(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.driver = webdriver;
	}

	@FindBy(id="username") WebElement loginTextField;
	@FindBy(id="password") WebElement pwTextField;
	@FindBy(id="submit") WebElement submitButton;
	@FindBy(id="auth-local-btn") WebElement userNamePasswordButton;

	@FindBy(css=".btn-donation.btn-lg.btn-block.share-new-size") WebElement donateButton;
	@FindBy(id="story-popup-donate-amt-option1") WebElement amountOption1;
	@FindBy(id="full_name") WebElement fullNameTextField;
	@FindBy(id="email_receipt") WebElement emailTextField;
	@FindBy(id="mobile") WebElement mobileTextField;
	@FindBy(id="city_text") WebElement cityTextField;
	@FindBy(id="story-popup-donate-button") WebElement donateSecondButton;
	@FindBy(id="cardNumber") WebElement cardNumberTextField;
	@FindBy(id="expiryDate") WebElement expiryDateTextField;
	@FindBy(id="cvvNumber") WebElement cvvNumberTextField;
	@FindBy(id="donate-card-contribute") WebElement donateThirdButton;


	public void login_WebAPP(String username , String password) {

		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(userNamePasswordButton));
		userNamePasswordButton.click();
		wait.until(ExpectedConditions.visibilityOf(loginTextField));
		loginTextField.sendKeys(username);
		pwTextField.sendKeys(password);
		submitButton.click();
	}

	public void stageAuthentication(String userName,String passWord) throws InterruptedException  {
		boolean opValue = false;	

		try {
			WebDriverWait alertWait = new WebDriverWait(driver, 3);
			Alert alert = alertWait.until(ExpectedConditions.alertIsPresent());
		}catch (Exception e) {
			System.out.println("Unable to switch to alert window");
		}
		try {
			rb = new Robot();


			//Enter user name by ctrl-v
			StringSelection username = new StringSelection(userName);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);            
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);

			//tab to password entry field
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);

			//Enter password by ctrl-v
			StringSelection pwd = new StringSelection(passWord);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);

			//press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		}

		catch (AWTException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			opValue = false;
		}
		catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			opValue = false;

		}
	}
	
	public void click_Donate() {
		wait.until(ExpectedConditions.visibilityOf(donateButton));
		donateButton.click();
		wait.until(ExpectedConditions.visibilityOf(amountOption1));
		amountOption1.click();
		fullNameTextField.sendKeys("Automation testing user");
		emailTextField.sendKeys("email@sampledomain.com");
		mobileTextField.sendKeys("9876543210");
		cityTextField.sendKeys("Mumbai");
		donateSecondButton.click();
	}
	public void cardPageField() {
		wait.until(ExpectedConditions.visibilityOf(cardNumberTextField ));	
		cardNumberTextField.sendKeys("5555555555554444");
		expiryDateTextField.sendKeys("12/22");
		cvvNumberTextField.sendKeys("123");
		donateThirdButton.click();
	}
}
