package com.advantageshopping.qa.base;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.advantageshopping.qa.util.TestUtil;
import com.advantageshopping.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\b.mahesh\\eclipse-workspace\\AdvantageShopping\\src\\main\\java\\com\\advantageshopping\\qa\\config\\config.properties");
			prop.load(file);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
	//	eventListener = new WebEventListener();//Create instance of Listener Class
       /* EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(eventListener); //Pass listener to constructor
         
        WebDriver decorated = decorator.decorate(driver);*/
       
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageLoadTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitWait));
		
		driver.get(prop.getProperty("url"));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.explicitWait));
	}

}
