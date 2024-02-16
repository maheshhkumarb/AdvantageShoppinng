package com.advantageshopping.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.advantageshopping.qa.base.TestBase;
import com.advantageshopping.qa.pages.HomePage;
import com.advantageshopping.qa.pages.LoginPage;
import com.advantageshopping.qa.pages.RegistrationPage;
import com.advantageshopping.qa.util.TestUtil;

public class RegistrationPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registerPage;
	
	String sheetName = "AdvantageShoppingTestData";
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		loginPage = new LoginPage();
		loginPage.userButtonClick();
		registerPage = loginPage.createAccount();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] object = TestUtil.getTestData(sheetName);
		return object;
	}
	
	@Test(dataProvider = "getData")
	public void register(String un, String em, String pwd,String confirmPwd, String ctry) throws InterruptedException {
		homePage = registerPage.registration(un, em, pwd, confirmPwd, ctry);
		Assert.assertEquals(un, homePage.getUsernameTitle());
		Thread.sleep(TestUtil.threadSleep);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
