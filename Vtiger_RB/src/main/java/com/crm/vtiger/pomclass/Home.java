package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Home extends WebDriverUtility{
WebDriver driver ;
public Home(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Organizations")
private WebElement organizationLnk;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorImg;

@FindBy(linkText="Sign Out")
private WebElement signOutLnk;
public WebDriver getDriver() {
	return driver;
}

public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getAdministratorImg() {
	return administratorImg;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}
	public void logout() {
		mouseHover(driver, administratorImg);
		signOutLnk.click();
		
	}


}
