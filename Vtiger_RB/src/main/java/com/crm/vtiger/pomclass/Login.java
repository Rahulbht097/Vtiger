package com.crm.vtiger.pomclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {//execute all the elements and initialize i.e. constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath = "//input[@id='submitButton']")})
	private WebElement loginBtn;
	

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
public void loginToApp(String UserName,String Password) {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	userNameEdt.sendKeys(UserName);
	userPasswordEdt.sendKeys(Password);
	loginBtn.click();
	}

}
