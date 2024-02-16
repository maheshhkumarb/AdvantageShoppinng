package com.advantageshopping.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.advantageshopping.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(id = "menuUser")
	WebElement userButton;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "sign_in_btn")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'CREATE NEW ACCOUNT')]")
	WebElement createNewAccount;
	
	
	//initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void userButtonClick() {
		userButton.click();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}
	
	public RegistrationPage createAccount() {
		createNewAccount = wait.until(ExpectedConditions.elementToBeClickable(createNewAccount));
		createNewAccount.click();
		
		return new RegistrationPage();
	}
}
