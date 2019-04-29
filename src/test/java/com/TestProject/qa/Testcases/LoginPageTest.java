package com.TestProject.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void getPageTitleTest() {
		
		String pageTitle = loginPage.getPageTitle();
		Assert.assertEquals(pageTitle, "CRM");
	}
	
	@Test(priority=2)
	public void loginPageTest() {
		
		homePage = loginPage.validateSuccessfulLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	

}
