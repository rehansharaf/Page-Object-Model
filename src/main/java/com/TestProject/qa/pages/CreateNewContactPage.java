package com.TestProject.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestProject.qa.base.TestBase;

public class CreateNewContactPage extends TestBase {

	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(name="value")
	WebElement email;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(name="do_not_call")
	WebElement doNotCallOption;
	
	@FindBy(name="do_not_text")
	WebElement doNotTextOption;
	
	@FindBy(name="do_not_email")
	WebElement doNotEmailOption;
	
	@FindBy(name="day")
	WebElement birthdayDay;
	
	@FindBy(name="year")
	WebElement birthdayYear;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement createdContactName;
	
	
	
	public CreateNewContactPage() {
		
		PageFactory.initElements(driver, this);
	}   
	
	
	public Boolean addNewContact(String FN, String LN, String MN, 
			String Email, String Description, String Category, String optionNotTo, String birthdayDay,
			String monthName, String birthdayYear) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		middleName.sendKeys(MN);
		email.sendKeys(Email);
		description.sendKeys(Description);
		
		driver.findElement(By.name("category")).click();
		driver.findElement(By.xpath("//div[@role='option']/span[text()='"+Category+"']")).click();
		
		if(optionNotTo.equals("Do Not Call")) 
			js.executeScript("arguments[0].click();", doNotCallOption); 
		
		else if(optionNotTo.equals("Do Not Text")) 	
			js.executeScript("arguments[0].click();", doNotTextOption);
		
		else if(optionNotTo.equals("Do Not Email")) 
			js.executeScript("arguments[0].click();", doNotEmailOption);		
		
		this.birthdayDay.sendKeys(birthdayDay);
		driver.findElement(By.name("month")).click();
		driver.findElement(By.xpath("//span[text()='"+monthName+"']")).click();
		this.birthdayYear.sendKeys(birthdayYear);
		saveBtn.click();
		
		try {
			
			return wait.until(ExpectedConditions.textToBePresentInElement(createdContactName, FN+" "+LN));
			
		}catch(Exception e) {
			
			return false;
		}
				
	}

}
