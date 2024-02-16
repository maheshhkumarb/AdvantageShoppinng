package com.advantageshopping.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantageshopping.qa.base.TestBase;

public class TabletsPage extends TestBase {
	
	//PageFactory - OR
	@FindBy(xpath = "//h3[contains (text(),'TABLETS')]")
	WebElement tabletsText;
	
	public TabletsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTabletsText() {
		return tabletsText.getText();
		
	}

}
