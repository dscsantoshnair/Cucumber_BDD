package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	/**
	 * This method is used to initialize the threadlocal driver on the basis of
	 * given browser
	 * @param browser
	 * @return tldriver.
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is :"+browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("chrome")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please pass the correct browser value :"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/*
	 * This is used to get the driver with ThreadLocal
	 * 
	 */
	public static synchronized WebDriver getDriver(){
		return tldriver.get();
	}
}
