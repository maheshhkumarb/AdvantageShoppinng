package com.advantageshopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantageshopping.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - OR
	@FindBy(xpath = "//span[@class='hi-user containMiniTitle ng-binding']")
	WebElement usernameVisible;
	
	@FindBy(id = "speakersTxt")
	WebElement speakers;
	
	@FindBy(id = "tabletsTxt")
	WebElement tablets;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getUsernameTitle() {
		return usernameVisible.getText();	
	}
	
	public SpeakersPage clickSpeakers() {
		speakers.click();
		return new SpeakersPage();
	}
	
	public TabletsPage clickTablets() {
		tablets.click();
		return new TabletsPage();
	}
}
