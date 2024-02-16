package com.advantageshopping.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.advantageshopping.qa.base.TestBase;
import com.advantageshopping.qa.pages.HomePage;
import com.advantageshopping.qa.pages.LoginPage;
import com.advantageshopping.qa.pages.SpeakersPage;
import com.advantageshopping.qa.pages.TabletsPage;
import com.advantageshopping.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SpeakersPage speakersPage;
	TabletsPage tabletsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
	}
	
	@Test
	public void clickSpeakers() throws InterruptedException {
		speakersPage = homePage.clickSpeakers();
		Assert.assertEquals("SPEAKERS", speakersPage.getSpeakersText());
		Thread.sleep(TestUtil.threadSleep);
	}
	
	@Test
	public void clickTablets() throws InterruptedException {
		tabletsPage = homePage.clickTablets();
		Assert.assertEquals("TABLETS", tabletsPage.getTabletsText());
		Thread.sleep(TestUtil.threadSleep);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
