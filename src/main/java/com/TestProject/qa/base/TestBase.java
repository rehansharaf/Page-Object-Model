package com.TestProject.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static long PAGE_LOAD_TIMEOUT;
	static long IMPLICIT_WAIT;
	static long EXPLICIT_WAIT;

	public TestBase() {

		prop = new Properties();

		try {
			
			FileInputStream fin = new FileInputStream(
					System.getProperty("user.dir")
							+ "/src/main/java/com/TestProject/qa/config/config.properties");
			prop.load(fin);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
		
		String browser = prop.getProperty("browser");
		
		PAGE_LOAD_TIMEOUT = Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT"));
		IMPLICIT_WAIT = Long.parseLong(prop.getProperty("IMPLICIT_WAIT"));
		EXPLICIT_WAIT = Long.parseLong(prop.getProperty("EXPLICIT_WAIT"));
		
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
			driver = new ChromeDriver();			
			
		}else if(browser.equals("FF")) {
			
			System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;	
		
		wait = new WebDriverWait(driver, EXPLICIT_WAIT);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
