package com.advantageshopping.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.advantageshopping.qa.base.TestBase;
import com.advantageshopping.qa.pages.HomePage;
import com.advantageshopping.qa.pages.LoginPage;
import com.advantageshopping.qa.pages.RegistrationPage;
import com.advantageshopping.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registerPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		loginPage.userButtonClick();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
     	Assert.assertEquals(prop.getProperty("username"), homePage.getUsernameTitle());
     	Thread.sleep(TestUtil.threadSleep);
	}
	
	@Test(priority=2)
	public void createAccount() throws InterruptedException {
		loginPage.userButtonClick();
		registerPage = loginPage.createAccount();
		Assert.assertEquals("CREATE ACCOUNT", registerPage.getCreateAccountText());
		Thread.sleep(TestUtil.threadSleep);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
