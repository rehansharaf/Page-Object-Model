package com.TestProject.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestProject.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='New']")
	WebElement newContactBtn;
	
	public ContactPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public CreateNewContactPage clickNewContactBtn() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", newContactBtn); 
		//newContactBtn.click();
		return new CreateNewContactPage();
	}

}
