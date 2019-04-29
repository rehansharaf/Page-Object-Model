package com.TestProject.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestProject.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;	
	
	@FindBy(xpath="//a[@href='https://register.cogmento.com/password/reset/request/']")
	WebElement forgotPassLink;
	
	@FindBy(xpath="//a[@text()='Classic CRM']")
	WebElement classicCRMLink;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	
	}
	
	public SignupPage signUpLinkFunctionality() {
		
		signUpLink.click();
		return new SignupPage();
	}
	
	public ClassicalCRMLoginPage classicalCRMLinkFunctionality() {
		
		classicCRMLink.click();
		return new ClassicalCRMLoginPage();
	}
	
	public ForgotPasswordPage forgotPasswordLinkFunctionality() {
		
		forgotPassLink.click();
		return new ForgotPasswordPage();
	}
	
	public HomePage validateSuccessfulLogin(String username, String password) {
		
		this.username.clear();
		this.username.sendKeys(username);
		this.password.clear();
		this.password.sendKeys(password);
		loginBtn.click();
		
		return new HomePage();
		
	}
}
