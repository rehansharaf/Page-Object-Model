package com.TestProject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestProject.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement loggedInNameText;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUserName() {
		
		return loggedInNameText.getText();
	}
	
	public ContactPage clickContactLink() {
		
		contactsLink.click();
		return new ContactPage();
		
	}

}
