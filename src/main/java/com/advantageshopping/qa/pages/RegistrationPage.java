package com.advantageshopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.advantageshopping.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	//Page Factory
	@FindBy(xpath = "//h3[contains (text(),'CREATE ACCOUNT')]")
	WebElement createAccountText;
	
	@FindBy(name = "usernameRegisterPage")
	WebElement username;
	
	@FindBy(name = "emailRegisterPage")
	WebElement email;
	
	@FindBy(name = "passwordRegisterPage")
	WebElement password;
	
	@FindBy(name = "confirm_passwordRegisterPage")
	WebElement confirmPassword;
	
	@FindBy(name = "countryListboxRegisterPage")
	WebElement country;
	
	@FindBy(name = "i_agree")
	WebElement agree;
	
	@FindBy(id = "register_btn")
	WebElement registerButton;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreateAccountText() {
		return createAccountText.getText();
	}
	
	public HomePage registration(String un, String em, String pwd,String confirmPwd, String ctry) {
		Select selectcountry = new Select(country);
		
		username.sendKeys(un);
		email.sendKeys(em);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(confirmPwd);
		selectcountry.selectByVisibleText(ctry);
		agree.click();
		registerButton.click();
		
		return new HomePage();
		
	}
	

}
