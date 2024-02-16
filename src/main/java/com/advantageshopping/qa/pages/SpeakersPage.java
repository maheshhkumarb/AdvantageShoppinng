package com.advantageshopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantageshopping.qa.base.TestBase;

public class SpeakersPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(xpath = "//h3[contains (text(),'SPEAKERS')]")
	WebElement speakersText;
	
	public SpeakersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSpeakersText() {
		return speakersText.getText();
		
	}

}
