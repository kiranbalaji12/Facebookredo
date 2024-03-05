package com.facebook.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.basefunction.BaseClass;

public class SignupLocators extends BaseClass {
	
	public SignupLocators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'account')]")
	private WebElement create;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement sname;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement number;
	
	@FindBy(xpath="//input[@name='reg_passwd__']")
	private WebElement pass;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement mon;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement yr;
	
	@FindBy(xpath="//label[text()='Male']")
	private WebElement gender;
	

	public WebElement getCreate() {
		return create;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getSname() {
		return sname;
	}

	public WebElement getNumber() {
		return number;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMon() {
		return mon;
	}

	public WebElement getYr() {
		return yr;
	}

	public WebElement getGender() {
		return gender;
	}
}
