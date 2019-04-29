package com.TestProject.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateSuccessfulLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyLoggedInUserNameTest() {
		
		String username = homePage.verifyUserName();
		Assert.assertEquals(username, "Rehan Sharaf", "Logged In UserName Appearing On Dashboard Not Matched");
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
