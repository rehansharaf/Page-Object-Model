package com.TestProject.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestProject.qa.base.TestBase;
import com.TestProject.qa.pages.ContactPage;
import com.TestProject.qa.pages.CreateNewContactPage;
import com.TestProject.qa.pages.HomePage;
import com.TestProject.qa.pages.LoginPage;
import com.TestProject.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	CreateNewContactPage createNewContactPage;
	
	public ContactPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateSuccessfulLogin(prop.getProperty("username"),
				prop.getProperty("password"));
		contactPage = homePage.clickContactLink();
		createNewContactPage = contactPage.clickNewContactBtn();

		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		
		return TestUtil.getTestData("CreateContact");
		
	}
	
	@Test(dataProvider="getTestData",priority=1)
	public void createNewContactTest(String firstName, String lastName, String middleName, String email,
			String description, String category, String notTo, String birthdayDay, String birthdayMonth,
			String birthdayYear) {
		
		Boolean checkUsername = createNewContactPage.addNewContact(firstName, lastName, middleName, email, 
				description, category, notTo, birthdayDay, birthdayMonth, birthdayYear);
		
		Assert.assertTrue(checkUsername, "Contact Name is Not Appearing Correct For Newly Created Contact");

	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
